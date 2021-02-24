package com.example.fertilizerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.fertilizerManage.entity.User;

@Repository
public interface LoginInfoMapper {
	
	User findLoginInfoByCondition(User user);
	
	
	//根据用户名查询对应的用户
	User findByUserName (@Param("userName") String userName);

}
