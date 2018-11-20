package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.user.admin.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
