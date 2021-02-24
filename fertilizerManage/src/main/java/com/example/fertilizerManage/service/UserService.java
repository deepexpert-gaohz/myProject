package com.example.fertilizerManage.service;

import java.util.List;

import com.example.fertilizerManage.entity.User;

public interface UserService {
	
	//查询所有的user的list
		List<User> findByAll();	

}
