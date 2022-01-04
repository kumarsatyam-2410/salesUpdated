package com.omc.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.omc.sales.entity.User;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.UsersRepository;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepository;

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

}
