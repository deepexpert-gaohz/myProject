package com.example.fertilizerManage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.fertilizerManage.entity.OrderList;
import com.example.fertilizerManage.mapper.OrderInfoMapper;
import com.example.fertilizerManage.service.OrderInfoService;


@Controller

public class OrderCotroller {

	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Autowired
	private OrderInfoService orderInfoService;
	
	@RequestMapping("/orderList")
	public String orderList(){
		return "article-list.html";
	}
	
	
	@RequestMapping("/findOrderListByCondition")
	@ResponseBody
	public String findOrderListByCondition(OrderList orderList,HttpServletRequest request){
		//分页操作
		String pageStr=request.getParameter("page");  //当前页
		String pageSize=request.getParameter("limit");//每页显示数量
		Integer pageNo = (Integer.valueOf(pageStr)-1)*Integer.valueOf(pageSize); 
		orderList.setPageNo(pageNo);
		orderList.setPageSize(Integer.valueOf(pageSize));
		JSONObject jsonObject=new JSONObject();
		List<OrderList> orderListDemo = orderInfoMapper.findOrderListByCondition(orderList);
		System.out.println("获取查询人信息：");
		try {
			jsonObject.put("code", 0);
			jsonObject.put("msg", "获取数据成功");
			/**
			 * 为了获取所有数据的总数
			 */
			orderList.setPageNo(0);
			orderList.setPageSize(Integer.MAX_VALUE);
			List<OrderList> orderListAll = orderInfoMapper.findOrderListByCondition(orderList);
			jsonObject.put("count", orderListAll.size());
			jsonObject.put("data", orderListDemo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(orderListDemo);
		return jsonObject.toString();
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping("/delOrderList")
	@ResponseBody
	public String delOrderList(@RequestBody OrderList orderList){
		System.out.println("要结算的数据");
		System.out.println(orderList);
		/**
		 * 执行对该对象orderList的删除操作（状态操作，逻辑删除）
		 */
		JSONObject jsonObject =new JSONObject();
		try {
			orderInfoService.updateOrderList(orderList);
			jsonObject.put("result", "success");
			return jsonObject.toString();
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("result", "defeat");
			return jsonObject.toString();
		}		
	}
	
}
