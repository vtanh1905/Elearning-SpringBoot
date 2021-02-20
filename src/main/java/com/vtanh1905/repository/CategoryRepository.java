package com.vtanh1905.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vtanh1905.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query("SELECT c FROM Category c")
	public Page<Category> findAllPaging(Pageable pageable);
}
