package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query(value = "select * from user where role =:roleNo", nativeQuery = true)
	public List<User> findAll(@Param("roleNo") Long roleNo);

	@Query(value = "select * from user where (user_id IN (select user_id from plant_users where plant_id IN (select plant_id from plant_users where user_id=:userIds))) AND user_id!=:userIds AND role=:roleNo", nativeQuery = true)
	public List<User> findData(@Param("roleNo") Long roleNo, @Param("userIds") Long userIds);

	public List<User> findTop10ByOrderByIdDesc();



}
