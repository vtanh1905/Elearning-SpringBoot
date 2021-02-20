package com.vtanh1905.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vtanh1905.dto.category.CategoryCreateDto;
import com.vtanh1905.dto.category.CategoryUpdateDto;
import com.vtanh1905.entity.Category;
import com.vtanh1905.repository.CategoryRepository;
import com.vtanh1905.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(CategoryCreateDto categoryCreateDto) {
		return categoryRepository.save(categoryCreateDto.toEntity());
	}

	@Override
	public Category edit(CategoryUpdateDto categoryUpdateDto) {
		// Check: If user don't type id
		final Integer id = categoryUpdateDto.getId();
		if (id == null) {
			return null;
		}
		// Check: If id is not exist
		final Category role = categoryRepository.findById(id).get();
		if (role == null) {
			return null;
		}
		return categoryRepository.save(categoryUpdateDto.toEntityWithDefaultValue(role));
	}

	@Override
	public boolean delete(Integer id) {
		// Check: If user don't type id
		if (id == null) {
			return false;
		}
		// Check: If id is not exist
		try {
			categoryRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Category findById(Integer id) {
		// Check: If user don't type id
		if (id == null) {
			return null;
		}
		// Check: If id is not exist
		try {
			return categoryRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<Category> findAllPaging(int indexPage, int maxRow, String orderById) {
		Sort sort = null;
		// Check OrderBy is not equal ASC OR DESC
		if (orderById.equalsIgnoreCase("DESC")) {
			sort = Sort.by("id").descending();
		}else {
			sort = Sort.by("id").ascending();
		}
		Pageable pageable = PageRequest.of(indexPage - 1, maxRow, sort);
		return categoryRepository.findAllPaging(pageable);
	}
}
