package com.example.fertilizerManage.service.impl;


import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.fertilizerManage.entity.Email;
import com.example.fertilizerManage.service.MailService;
@Service
public class MailServiceImpl implements MailService{

	
	private final Logger logger=LoggerFactory.getLogger(MailServiceImpl.class);
	@Autowired
	private JavaMailSender mailSender;
	@Value("${mail.fromMail.addr}")
	private String from;
	
	@Override
	public void send(Email email) throws Exception {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(email.getEmailAddr());
		mailMessage.setSubject(email.getSubject());
		mailMessage.setText(email.getContent());

        
		try {
			mailSender.send(mailMessage);
			logger.info("简单邮件已经发送。");
		} catch (Exception e) {
			 logger.error("发送简单邮件时发生异常！", e);
		}
		
	}

	@Override
	public void sendAttenchmentsMail(Email email, String filePath)
			throws Exception {
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setSubject(email.getSubject());
			helper.setTo(email.getEmailAddr());
			helper.setText(email.getContent(), true);
			FileSystemResource fileSystemResource=new FileSystemResource(filePath);
			String fileName =filePath.substring(filePath.lastIndexOf(File.separator));
			System.out.println(fileName);
			logger.info(fileName);
			helper.addAttachment(fileName, fileSystemResource);
			 mailSender.send(message);
			 logger.info("带附件的邮件已经发送。");
		} catch (Exception e) {
			logger.error("发送带附件的邮件时发生异常！", e);
		}
		

	}



}
