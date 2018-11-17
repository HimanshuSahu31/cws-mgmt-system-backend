package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
