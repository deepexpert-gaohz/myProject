package com.example.fertilizerManage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.ResponseBody;

import com.example.fertilizerManage.entity.User;
import com.example.fertilizerManage.mapper.LoginInfoMapper;
import com.example.fertilizerManage.util.RandomValidateCodeUtils;
import com.example.fertilizerManage.util.SystemUtils;



@Controller
public class LoginController {

	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	
	
	//登录路径路口
	@RequestMapping({"/","/index"})
	public String login(){
		return "login.html";
	}
	
	@RequestMapping("/vertify")
	@ResponseBody
	public String vertify(HttpServletRequest Request,User user,HttpSession session){
		System.out.println("用户名是："+user.getLogin_name());
		System.out.println("获取校验码"+Request.getParameter("verity"));
		
		//获取校验码
		String verity=Request.getParameter("verity");
        //校验登录的用户名和密码是否正确
        User userDemo=  loginInfoMapper.findLoginInfoByCondition(user);
        System.out.println(userDemo);
        String userName= "";
        
        if(userDemo !=null){
        	 userName=userDemo.getLogin_name();        	
        }
		JSONObject jsonObject =new JSONObject();
		try {
			if(!session.getAttribute("verification_code").toString().equalsIgnoreCase(verity)){
				jsonObject.put("result", "defeat");
			}else{
				if(userDemo !=null){
		        	/* userName=userDemo.getLogin_name();
		        	jsonObject.put("userName", userName);
		 			jsonObject.put("result", "success");*/
					/**
		        	 * 使用 shiro 编写认证操作
		        	 */
					Subject subject =SecurityUtils.getSubject();
					//封装用户数据
					UsernamePasswordToken usernamePasswordToken =new UsernamePasswordToken(userName, userDemo.getPassword());
					//执行登录方法
					subject.login(usernamePasswordToken);
					
					//--------------------------------------------------------
					
					jsonObject.put("userName", userName);
		 			jsonObject.put("result", "success");
		        }else{
		        	jsonObject.put("result", "false");
		        }
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
	//进入主页路口
		@RequestMapping("/indexLL")
		public String indexLL(HttpServletRequest request,Model model){
		String userName =	request.getParameter("userName");
		model.addAttribute("userName", userName);
		//request.setAttribute("userName", userName);
			return "index";
		}
		
		
		@RequestMapping("/welcome")
		public String welcome(){
			return "welcome.html";
		}
	
		@RequestMapping("/adminInfo")
		public String adminInfo(){
			return "admin-info.html";
		}
		
		@GetMapping("/verificationCode")
	    @ResponseBody
	    public void verificationCode(HttpSession session, HttpServletResponse response) {

	        String code = SystemUtils.getRandomCode(4);
	        session.setAttribute("verification_code", code.toLowerCase());
	        RandomValidateCodeUtils.getRandcode(response, code);
	    }
		
		
}
