package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.office.type.Cubicle;

@Repository
public interface CubicleRepository extends JpaRepository<Cubicle, Long> {

}
