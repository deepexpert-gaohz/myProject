package com.example.fertilizerManage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	@RequestMapping("/hello")
	public String index(){
		return "good afternoon";
	}

}
