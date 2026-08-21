package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}
