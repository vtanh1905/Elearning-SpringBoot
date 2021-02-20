package com.vtanh1905.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vtanh1905.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("SELECT r FROM Role r")
	public Page<Role> findAllPaging(Pageable pageable);
}
