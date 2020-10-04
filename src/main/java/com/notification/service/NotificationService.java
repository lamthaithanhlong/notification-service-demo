package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notification.rest.dto.NotificationDto;

@Service
public class NotificationService {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendMail(NotificationDto data) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(data.getReceivers().stream().toArray(String[]::new));
		msg.setSubject(data.getObject());
		msg.setText(data.getMessage());

		javaMailSender.send(msg);
	}

}
