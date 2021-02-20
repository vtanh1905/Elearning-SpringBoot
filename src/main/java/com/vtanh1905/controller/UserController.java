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

import com.vtanh1905.dto.user.UserCreateDto;
import com.vtanh1905.dto.user.UserUpdateDto;
import com.vtanh1905.entity.User;
import com.vtanh1905.service.UserService;
import com.vtanh1905.utils.ResponseUtil;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("")
	public Object get(@RequestParam(required = false, defaultValue = "1") int indexPage,
			@RequestParam(required = false, defaultValue = "10") int maxRow,
			@RequestParam(required = false, defaultValue = "ASC") String orderById) {
		return ResponseUtil.writeGetPagination(userService.findAllPaging(indexPage, maxRow, orderById));
	}
	
	@PostMapping("")
	public Object post(@RequestBody UserCreateDto userCreateDto) {
		return ResponseUtil.writeGet(userService.save(userCreateDto));
	}
	
	@PutMapping("")
	public Object put(@RequestBody UserUpdateDto userUpdateDto) {
		User result = userService.edit(userUpdateDto);
		if (result == null) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writePut(result);
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable Integer id) {
		if (userService.delete(id) == false) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writeDelete("Delete Successfully");
	}
	
	@GetMapping("/{id}")
	public Object getById(@PathVariable Integer id) {
		User result = userService.findById(id);
		if (result == null) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writeGet(result);
	}
	
	@GetMapping("/details")
	public Object getDetails(@RequestParam(required = false, defaultValue = "1") int indexPage,
			@RequestParam(required = false, defaultValue = "10") int maxRow,
			@RequestParam(required = false, defaultValue = "ASC") String orderById) {
		return ResponseUtil.writeGetPagination(userService.findAllDetailsPaging(indexPage, maxRow, orderById));
	}
}
