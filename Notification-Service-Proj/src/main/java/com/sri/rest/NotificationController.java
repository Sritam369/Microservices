package com.sri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.entity.Notification;
import com.sri.service.INotificationService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notification")
@Slf4j
public class NotificationController {

    @Autowired
    private INotificationService service;

    @PostMapping("/add")
    @CircuitBreaker(name = "add", fallbackMethod = "addFallback")
    public ResponseEntity<String> addNotification(
            @RequestBody Notification notification) {

        String result = service.addNotification(notification);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<String> addFallback(Notification notification, Exception e) {

        return new ResponseEntity<>("Notification can't be generated currently due to an internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Notification>> showAllNotifications() {

        List<Notification> notifications = service.getAllNotifications();

        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/show/{notificationId}")
    public ResponseEntity<Notification> showNotificationById(@PathVariable Integer notificationId) {

        Notification notification =service.getNotificationById(notificationId);

        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateNotification(@RequestBody Notification notification) {

        String result = service.updateNotification(notification);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<String> deleteNotification(@PathVariable Integer notificationId) {

        String result = service.deleteNotification(notificationId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}