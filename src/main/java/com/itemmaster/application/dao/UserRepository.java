package com.itemmaster.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itemmaster.application.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findOneByUsername(String username);
	
}
