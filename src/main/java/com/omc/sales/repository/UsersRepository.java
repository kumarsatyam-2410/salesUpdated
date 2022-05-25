package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.User;



/**
 * The Interface UsersRepository.
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	public List<User> findByEmailAndPassword(String emailId, String password);
	
	public User findByEmail(String emailId);
	
	public List<User> findByEmailAndPasswordAndRole(String emailId, String password , int role);

}
