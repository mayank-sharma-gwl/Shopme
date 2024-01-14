package com.oops.JustBuyIt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oops.JustBuyIt.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	
	Optional<User> findUserByEmail(String email);
}
