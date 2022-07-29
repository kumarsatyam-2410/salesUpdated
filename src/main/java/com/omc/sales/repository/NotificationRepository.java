package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Customer;
import com.omc.sales.entity.Notification;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	public Notification findByNotificationType(String notificationType);
	
	public Notification findByNotificationMode(String notificationMode);
	
	public Notification findByNotificationTypeAndNotificationMode(String notificationType,String notificationMode);

	public List<Notification> findAllByOrderByIdDesc();
	

}
