package com.example.fertilizerManage.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.fertilizerManage.entity.User;

@Repository
public interface UserMapper {

	List<User> findByAll();
}
