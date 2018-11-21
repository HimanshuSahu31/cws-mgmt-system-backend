package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.user.customer.SingleUser;

@Repository
public interface SingleUserRepository extends JpaRepository<SingleUser, Long>{

}
