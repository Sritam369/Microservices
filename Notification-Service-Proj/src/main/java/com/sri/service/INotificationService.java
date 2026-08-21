package com.sri.service;

import java.util.List;

import com.sri.entity.Notification;

public interface INotificationService {

	String addNotification(Notification notification);

    List<Notification> getAllNotifications();

    Notification getNotificationById(Integer notificationId);

    String updateNotification(Notification notification);

    String deleteNotification(Integer notificationId);
}
