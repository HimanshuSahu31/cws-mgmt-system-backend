package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.workspace.Workspace;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long>{
	
}
