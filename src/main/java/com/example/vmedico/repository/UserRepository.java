package com.example.vmedico.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vmedico.entity.User;

@Repository("userRepository")
public interface UserRepository  extends CrudRepository<User, Long> {
	 User findByEmail(String email);
		
	 User findByConfirmationToken(String confirmationToken);
	 
	  List<User> findAll();
}
