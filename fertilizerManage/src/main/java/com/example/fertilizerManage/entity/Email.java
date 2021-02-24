package com.example.fertilizerManage.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author ghz
 * AUTO : 
 *
 */
public class Email implements Serializable{


	private static final long serialVersionUID = -3761698566938633914L;
	
	//必填参数
	private String emailAddr;  //收件方地址
	private String subject;    //邮件的主题
	private String content;   //邮件内容
	
	//选填
	private String template;  //模板
	
	private Map<String,String> kMap;  //自定义参数

	public Email() {
	}

	public Email(String emailAddr, String subject, String content,
			String template, Map<String, String> kMap) {
		super();
		this.emailAddr = emailAddr;
		this.subject = subject;
		this.content = content;
		this.template = template;
		this.kMap = kMap;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Map<String, String> getkMap() {
		return kMap;
	}

	public void setkMap(Map<String, String> kMap) {
		this.kMap = kMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [emailAddr=");
		builder.append(emailAddr);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", content=");
		builder.append(content);
		builder.append(", template=");
		builder.append(template);
		builder.append(", kMap=");
		builder.append(kMap);
		builder.append("]");
		return builder.toString();
	}
		
	
	

}
