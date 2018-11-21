package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.user.receptionist.Receptionist;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long>{

}
