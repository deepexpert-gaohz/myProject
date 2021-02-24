package com.example.fertilizerManage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fertilizerManage.entity.User;
import com.example.fertilizerManage.mapper.UserMapper;
import com.example.fertilizerManage.service.UserService;

@Service
public class UserServiceImpl implements UserService{

   @Autowired
   private UserMapper userMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public List<User> findByAll() {
		logger.info("hahahaah+你好啊");
		return 	userMapper.findByAll();
		
	}

}
