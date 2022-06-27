package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.LoginDTO;
import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantUsers;
import com.omc.sales.entity.Role;
import com.omc.sales.entity.User;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.PlantUsersRepository;
import com.omc.sales.repository.UsersRepository;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private PlantUsersRepository plantUsersRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null){
			throw new SSNSQLException("User Not found", ErrorCodes.USER_NOT_FOUND);
		}
		return new MyUserDetails(user);
	}
	
	public User getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public User getUserById(String id){
		return userRepository.findById(Long.valueOf(id)).get();
	}
 /////////////////////////////
	public List<User> login(LoginDTO loginDTO) {
		
	     String email=loginDTO.getEmail();
	     String password=loginDTO.getPassword();
	   //  int role=loginDTO.getRoleId();
	      return userRepository.findByEmailAndPassword(email, password);
	     	
	}

	public List<User> getUserList() {
		
		return userRepository.findAll();
	}

	
	public List<User> getUserListByPlantId(Long plantIds) {
		return plantUsersRepository.findUserByPlant(plantIds);
	}

}
