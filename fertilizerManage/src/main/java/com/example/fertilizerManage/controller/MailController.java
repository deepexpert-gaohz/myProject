package com.example.fertilizerManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fertilizerManage.entity.Email;
import com.example.fertilizerManage.entity.User;
import com.example.fertilizerManage.service.MailService;

@RestController
@RequestMapping("/mailTest")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping("/findALL")
	public void GetUsers() throws Exception{
		Email email =new Email();
		email.setContent("Hello,你有一份附件请查收");
		email.setEmailAddr("377173853@qq.com");
		email.setSubject("test simple mail");
		 mailService.send(email);
		 System.out.println("发送成功");
	}
	
	@RequestMapping("/findYou")
	public String sendAttenchmentsMail() throws Exception{
		Email email =new Email();
		email.setContent("Hello,你有一份附件请查收");
		email.setEmailAddr("377173853@qq.com");
		email.setSubject("test simple mail");
		mailService.sendAttenchmentsMail(email, "F:\\lombok-1.18.6.jar");
		return "跳转了";
	}
	
}
