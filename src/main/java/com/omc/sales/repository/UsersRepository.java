package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.User;



/**
 * The Interface UsersRepository.
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	public User findByEmailAndPassword(String emailId, String password);
	
	public User findByEmail(String emailId);

}
