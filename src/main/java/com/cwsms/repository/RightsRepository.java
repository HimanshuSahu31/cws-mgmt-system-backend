package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.user.Rights;

@Repository
public interface RightsRepository extends JpaRepository<Rights, Long>{

}
