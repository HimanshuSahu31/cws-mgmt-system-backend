package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.office.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{

}
