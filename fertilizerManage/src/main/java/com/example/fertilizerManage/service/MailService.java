package com.example.fertilizerManage.service;

import com.example.fertilizerManage.entity.Email;

public interface MailService {
	
	void send (Email email) throws Exception;
	
	/**
	 * 发送带附件的邮件
	 * @return
	 * @throws Exception
	 */
	void sendAttenchmentsMail(Email email,String filePath)throws Exception;

}
