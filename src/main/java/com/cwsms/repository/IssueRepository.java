package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.issue.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{

}
