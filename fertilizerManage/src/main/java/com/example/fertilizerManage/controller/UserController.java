package com.example.fertilizerManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fertilizerManage.entity.User;
import com.example.fertilizerManage.service.UserService;

@RestController
@RequestMapping("/test")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findALL")
	public List<User> GetUsers(){
		return userService.findByAll();
	}
	
}
