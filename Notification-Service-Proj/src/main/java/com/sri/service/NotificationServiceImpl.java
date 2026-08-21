package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.client.PaymentConsumerClient;
import com.sri.dto.PaymentResponse;
import com.sri.entity.Notification;
import com.sri.exception.NotificationNotFoundException;
import com.sri.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	private NotificationRepository repo;
	@Autowired
	private PaymentConsumerClient client;
	
	@Override
	public String addNotification(Notification noti) {
		
		PaymentResponse pay = client.getPaymentIdConsumer(noti.getPaymentId());
		
		if(!pay.getPaymentStatus().equalsIgnoreCase("success")) {
			return "Notification can't be generated because Payment failed";
		}
		else {
		noti.setMessage( "Payment successful for payment id : "+ pay.getPaymentId());
	    Notification save = repo.save(noti);
	    return "Notification record saved with id : "+save.getNotificationId();
		}
	}

	@Override
	public List<Notification> getAllNotifications() {
	    return repo.findAll();
	}

	@Override
	public Notification getNotificationById(Integer notificationId) {
	    return repo.findById(notificationId).orElseThrow(()-> new NotificationNotFoundException("Notification id doesn't exist"));
	}

	@Override
	public String updateNotification(Notification noti) {
		Notification n = repo.findById(noti.getNotificationId()).orElseThrow(()-> new NotificationNotFoundException("Notification id doesn't exist"));
	    n.setMessage(noti.getMessage());
	    n.setNotificationStatus(noti.getNotificationStatus());
	    n.setNotificationType(noti.getNotificationType());
	    
	    Notification save = repo.save(n);
	    return "Notification with id : "+ save.getNotificationId()+ " updated successfully";
	}

	@Override
	public String deleteNotification(Integer notificationId) {
		 Notification notification = repo.findById(notificationId).orElseThrow(() ->new NotificationNotFoundException("Notification id doesn't exist"));

	        repo.delete(notification);

	        return "Notification with id : "+ notificationId+" deleted successfully";
	}
}