package com.example.fertilizerManage.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.fertilizerManage.entity.User;
import com.example.fertilizerManage.mapper.LoginInfoMapper;

public class MyShiroRealm extends AuthenticatingRealm{
	
	@Autowired
	private LoginInfoMapper  loginInfoMapper;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1. 构造  UsernamePasswordToken
        UsernamePasswordToken uptoken=(UsernamePasswordToken)token;
        //2,获取用户名密码
        String loginName = uptoken.getUsername();
        String password  = new String((char[])uptoken.getPassword());
        System.out.println("获取的输入账号密码分别为："+loginName+"----"+password);
        //根据loginName  获取数据库中 对应 user的信息
        User user= loginInfoMapper.findByUserName(loginName);
        System.out.println("查询到的USER为"+user);
        if(user == null){
        	throw new UnknownAccountException();
        }
        if(!password.equals(user.getPassword())){
        	throw new IncorrectCredentialsException();
        }

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo(loginName, user.getPassword(), getName());
		return simpleAuthenticationInfo;
	}

}
