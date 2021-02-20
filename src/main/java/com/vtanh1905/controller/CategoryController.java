package com.vtanh1905.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtanh1905.dto.category.CategoryCreateDto;
import com.vtanh1905.dto.category.CategoryUpdateDto;
import com.vtanh1905.entity.Category;
import com.vtanh1905.service.CategoryService;
import com.vtanh1905.utils.ResponseUtil;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("")
	public Object get(@RequestParam(required = false, defaultValue = "1") int indexPage,
			@RequestParam(required = false, defaultValue = "10") int maxRow,
			@RequestParam(required = false, defaultValue = "ASC") String orderById) {
		return ResponseUtil.writeGetPagination(categoryService.findAllPaging(indexPage, maxRow, orderById));
	}

	@PostMapping("")
	public Object post(@RequestBody CategoryCreateDto categoryCreateDto) {
		return ResponseUtil.writeGet(categoryService.save(categoryCreateDto));
	}

	@PutMapping("")
	public Object put(@RequestBody CategoryUpdateDto categoryUpdateDto) {
		Category result = categoryService.edit(categoryUpdateDto);
		if (result == null) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writePut(result);
	}

	@DeleteMapping("/{id}")
	public Object deleteById(@PathVariable Integer id) {
		if (categoryService.delete(id) == false) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writeDelete("Delete Successfully");
	}

	@GetMapping("/no-pagination")
	public Object getNoPagination() {
		return ResponseUtil.writeGet(categoryService.findAll());
	}

	@GetMapping("/{id}")
	public Object getById(@PathVariable Integer id) {
		Category result = categoryService.findById(id);
		if (result == null) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writeGet(result);
	}
}
