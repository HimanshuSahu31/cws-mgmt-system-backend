package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.address.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
