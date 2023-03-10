package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import com.omc.sales.dto.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omc.sales.entity.CafTable;
import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantSalesInventory;
import com.omc.sales.entity.PlantUsers;
import com.omc.sales.entity.User;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.DashBoardService;
import com.omc.sales.service.UserService;


/**
 * The Class UserController.
 */
@CrossOrigin
@RestController
@RequestMapping("rms")
public class UserController {

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private DashBoardService dashBoardService;
	

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public void testUser() 
	{
		LOGGER.info("Test successfull");
	}

	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public User getPlantsByUser(@PathVariable String email) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		ResponseEntity<UserResponseDTO> responseEntity;
		try{
			LOGGER.info("In UserController for checkUser Request");
			User isUser = userService.getUserByEmail(email);
			return isUser;
		}
		catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			userResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(userResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			userResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating user", exception);
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating user", exception);
		}
		return null;
	}

	
	
	@RequestMapping(value = "/dashbord/{userId}", method = RequestMethod.GET)
	public DashboardDTO getDashbordByUser(@PathVariable String userId) {
		DashboardDTO userResponseDTO = new DashboardDTO();
		ResponseEntity<DashboardDTO> responseEntity;
		try{
			LOGGER.info("In UserController for dashboard Request");
			return dashBoardService.prepareDashBoard(Long.valueOf(userId));
			 
		}
		catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			//userResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			//userResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(userResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			//userResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating user", exception);
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating user", exception);
		}
		return null;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserListResponseDTO> login(@RequestBody LoginDTO loginDTO) {

		ResponseEntity<UserListResponseDTO> responseEntity;
		UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
		List<User> list =new ArrayList<>();
		try{
			LOGGER.info("In UserController for loging Request");
			list = userService.login(loginDTO);
			userListResponseDTO.setStatus(HttpStatus.CREATED.value());
			userListResponseDTO.setList(list);
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			userListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			userListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			userListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.BAD_REQUEST);	
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating Logging", exception);
			userListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating Logging", exception);
			userListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/get_user_list", method = RequestMethod.GET)
	public ResponseEntity<UserListResponseDTO> getUserList() {

		ResponseEntity<UserListResponseDTO> responseEntity;
		List<User> list=new ArrayList<>();
		UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
		try{
			list =userService.getUserList();
			userListResponseDTO.setList(list);
			userListResponseDTO.setStatus(HttpStatus.CREATED.value());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			userListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			userListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			userListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			userListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/get_user_list/{plantId}", method = RequestMethod.GET)
	public ResponseEntity<UserListResponseDTO> getUserListByPlantId(@PathVariable Long plantId) {

		ResponseEntity<UserListResponseDTO> responseEntity;
		List<User> list=new ArrayList<>();
		UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
		try{
			list =userService.getUserListByPlantId(plantId);
			userListResponseDTO.setList(list);
			userListResponseDTO.setStatus(HttpStatus.CREATED.value());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			userListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			userListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			userListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			userListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	
	@RequestMapping(value = "/getUsersList/{roleNo}", method = RequestMethod.GET)
	public ResponseEntity<UserListResponseDTO> getUserListByRoles(@PathVariable Long roleNo) {

		ResponseEntity<UserListResponseDTO> responseEntity;
		List<User> list=new ArrayList<>();
		UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
		try{
			list =userService.getUserListByRole(roleNo);
			userListResponseDTO.setList(list);
			userListResponseDTO.setStatus(HttpStatus.CREATED.value());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			userListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			userListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			userListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			userListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	
	@RequestMapping(value = "/getUsersListByPlantIdAndRoleNo/", method = RequestMethod.GET)
	public ResponseEntity<UserListResponseDTO> getUserListByRolesAndPlantId(@RequestParam Long roleNo,@RequestParam Long userIds) {

		ResponseEntity<UserListResponseDTO> responseEntity;
		List<User> list=new ArrayList<>();
		UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
		try{
			list =userService.getUserListByRolesAndPlantId(roleNo,userIds);
			userListResponseDTO.setList(list);
			userListResponseDTO.setStatus(HttpStatus.CREATED.value());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			userListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			userListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			userListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(userListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			userListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			userListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(userListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
		ResponseEntity<UserResponseDTO> response;
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		try {
			LOGGER.info("In USER Controller for deleting User Request");
			Long Id=userService.deleteUser(id);
			userResponseDTO.setStatus(HttpStatus.OK.value());
			userResponseDTO.setId(id);
			response = new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting user", e);
			userResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(userResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			userResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting plant", e);
			userResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(userResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			userResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}

	
}
