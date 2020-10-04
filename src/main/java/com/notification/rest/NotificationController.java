package com.notification.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notification.rest.dto.NotificationDto;
import com.notification.service.NotificationService;

import lombok.extern.apachecommons.CommonsLog;

@RestController
@CommonsLog
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	@PostMapping("/send-notification")
	public NotificationDto sendNotification(@RequestBody NotificationDto data) {
		log.info("mail info : " + data);
		notificationService.sendMail(data);
		return data;
	}

}
