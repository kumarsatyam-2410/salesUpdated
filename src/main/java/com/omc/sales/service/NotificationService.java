package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.NotificationDTO;
import com.omc.sales.entity.Notification;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.NotificationRepository;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class NotificationService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(NotificationService.class);

	/** The notification repository. */
	@Autowired
	private NotificationRepository notificationRepository;


	/**
	 * Creates the notification.
	 *
	 * @param notificationDTO  the notification DTO
	 * @param callInfo the call info
	 * @return the string
	 * @throws SSNSQLException 
	 * @throws Throwable 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createNotification(NotificationDTO notificationDTO) throws SSNSQLException{

		LOGGER.info("Request Received for createNotification with parameters:"+ "notificationType: " + notificationDTO.getNotificationType());

		// validate unique notification
		Notification existingNotificationEntity = notificationRepository.findByNotificationTypeAndNotificationMode(notificationDTO.getNotificationType(),notificationDTO.getNotificationMode());
		if(existingNotificationEntity != null){
			throw new SSNSQLException("Not Unique Notification", ErrorCodes.NOT_UNIQUE_NOTIFICATION);
		}
		
		Notification notificationEntity = new Notification();
		notificationEntity.setActive(notificationDTO.isActive());
		notificationEntity.setNotificationType(notificationDTO.getNotificationType());
		notificationEntity.setNotificationMode(notificationDTO.getNotificationMode());
		notificationEntity.setMessage(notificationDTO.getMessage());
		notificationEntity.setAddedOn(notificationDTO.getAddedOn());
		notificationEntity.setUpdatedOn(notificationDTO.getUpdatedOn());
		notificationRepository.save(notificationEntity);

		LOGGER.info("Out createNotification service with return Value notificationId:"+notificationEntity.getId()); 
		return notificationEntity.getId();
	}


	/**
	 * List all notifications.
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Notification> listAllNotifications() {
		LOGGER.info("In listAllNotifications  Service");
//		List<Notification> notification = new ArrayList<>();
//		notificationRepository.findAll().forEach(notification::add);
//		return notification;
		return notificationRepository.findAllByOrderByIdDesc();
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateNotification(NotificationDTO notificationDTO) {
		LOGGER.info("In updateNotification  Service");
		Notification notificationEntity = notificationRepository.findByNotificationTypeAndNotificationMode(notificationDTO.getNotificationType(),notificationDTO.getNotificationMode());
		notificationEntity.setActive(notificationDTO.isActive());
		notificationEntity.setMessage(notificationDTO.getMessage());
		notificationEntity.setAddedOn(notificationDTO.getAddedOn());
		notificationEntity.setUpdatedOn(notificationDTO.getUpdatedOn());
		//notificationEntity.setAddedOn(notificationDTO.getAddedOn());
		
		LOGGER.info("Out Notification Updated for "+notificationEntity.getId()); 
		return notificationEntity.getId();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteNotification(Long id) {
		LOGGER.info("In deleteNotification  Service" + notificationRepository.deleteByid(id));
		Long aid = notificationRepository.deleteByid(id);
		return id;


	}

}
