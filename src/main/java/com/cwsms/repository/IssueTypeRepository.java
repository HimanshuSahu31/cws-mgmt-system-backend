package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.issue.type.IssueType;

@Repository
public interface IssueTypeRepository extends JpaRepository<IssueType, Long>{

}
