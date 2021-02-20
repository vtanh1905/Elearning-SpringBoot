package com.vtanh1905.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vtanh1905.dto.category.CategoryCreateDto;
import com.vtanh1905.dto.category.CategoryUpdateDto;
import com.vtanh1905.entity.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Page<Category> findAllPaging(int indexPage, int maxRow, String orderById);
	public Category save(CategoryCreateDto categoryCreateDto);
	public Category edit(CategoryUpdateDto categoryUpdateDto);
	public boolean delete(Integer id);
	public Category findById(Integer id);
}
