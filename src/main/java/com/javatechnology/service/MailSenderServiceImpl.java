package com.javatechnology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
@Service
public class MailSenderServiceImpl implements MailService{
	@Autowired
	private MailSender mailSender;
	/*@Autowired
	private MailMessage MailMessage;*/
	@Override
	public void sendEmail(String message) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("test@gmail.com");
		mailMessage.setTo("test@gmail.com");
		mailMessage.setSubject("test");
		mailMessage.setText(message);
		mailSender.send(mailMessage);
		
	}
	

}
