package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.NotificationDTO;
import com.omc.sales.dto.NotificationListResponseDTO;
import com.omc.sales.dto.NotificationResponseDTO;
import com.omc.sales.entity.Notification;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.NotificationService;

/**
 * The Class NotificationController.
 */
@CrossOrigin
@RestController
@RequestMapping("sales")
public class NotificationController {

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(NotificationController.class);

	@Autowired
	private NotificationService notificationService;
	

	@RequestMapping(value = "/notification", method = RequestMethod.POST)
	public ResponseEntity<NotificationResponseDTO> addNotification(@RequestBody NotificationDTO notificationDTO) {

		ResponseEntity<NotificationResponseDTO> responseEntity;
		NotificationResponseDTO notificationResponseDTO = new NotificationResponseDTO();
		try{
			LOGGER.info("In NotificationController for addNotification Request");
			Long id = notificationService.createNotification(notificationDTO);
			notificationResponseDTO.setStatus(HttpStatus.CREATED.value());
			notificationResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(notificationResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			notificationResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			notificationResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(notificationResponseDTO,HttpStatus.BAD_REQUEST);
			notificationResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating notification", exception);
			notificationResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			notificationResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(notificationResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			notificationResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating notification", exception);
			notificationResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			notificationResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(notificationResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			notificationResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}


	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public List<Notification> listAll() {

		ResponseEntity<NotificationListResponseDTO> responseEntity;
		List<Notification> list = new ArrayList<>();
		NotificationListResponseDTO notificationResponseDTO = new NotificationListResponseDTO();
		try{
			LOGGER.info("In NotificationController for listAll Notifications Request");	
			list = notificationService.listAllNotifications();
			notificationResponseDTO.setList(list);
			notificationResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(notificationResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing notification", exception);
			notificationResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			notificationResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(notificationResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			notificationResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing notification", exception);
			notificationResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			notificationResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(notificationResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			notificationResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}


	@RequestMapping(value = { "/notification" }, method = RequestMethod.PUT)
	public ResponseEntity<NotificationResponseDTO>  updateNotification(@RequestBody NotificationDTO notificationDTO) {
		ResponseEntity<NotificationResponseDTO> responseEntity;
		NotificationResponseDTO notificationResponseDTO = new NotificationResponseDTO();
		try{
			LOGGER.info("In NotificationController for updateNotification Request");
			Long notificationId = notificationService.updateNotification(notificationDTO);
			notificationResponseDTO.setId(notificationId);
			notificationResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(notificationResponseDTO, HttpStatus.OK);
		}  catch(RuntimeException exception){
			LOGGER.warn("Error occurred while updating CPOC URL", exception);
			notificationResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			notificationResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(notificationResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			notificationResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating CPOC URL", exception);
			notificationResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			notificationResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(notificationResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			notificationResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;

	}
}
