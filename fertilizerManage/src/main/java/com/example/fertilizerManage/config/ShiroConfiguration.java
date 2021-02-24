package com.example.fertilizerManage.config;


import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import com.example.fertilizerManage.shiro.MyShiroRealm;

@Configuration
public class ShiroConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

	/**
	 * Shiro Realm 继承自AuthorizingRealm的自定义Realm,即指定Shiro验证用户登录的类为自定义的
	 */
	@Bean
	public MyShiroRealm MyShiroRealm(){
		return new MyShiroRealm();
	}
	
	/**
	 * 权限管理
	 */
	@Bean
	public SecurityManager securityManager() {
		logger.info("=======================shiro=======================");
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(MyShiroRealm());
		// securityManager.setRememberMeManager(rememberMeManager);
		return securityManager;
	}
	
	/**
	 * Shiro的Web过滤器Factory 命名:shiroFilter
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		// Shiro的核心安全接口,这个属性是必须的
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		/*
		 * 定义shiro过滤链 Map结构
		 * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
		 * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
		 * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.
		 * FormAuthenticationFilter
		 */
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		/*
		 * 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边; authc:所有url都必须认证通过才可以访问;
		 * anon:所有url都都可以匿名访问
		 */
		filterChainDefinitionMap.put("/index", "anon");
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/indexLL", "authc"); //主界面
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
	}
}
