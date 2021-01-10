package com.vtanh1905.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtanh1905.entity.Role;
import com.vtanh1905.utils.ResponseUtil;

@RestController
@RequestMapping("/api/example")
@CrossOrigin("*")
public class ExampleController {
	
	@GetMapping("")
	public Object get() {
		Role role = new Role(1, "23", "32");
//		return ResponseUtil.writeBad();
		return ResponseUtil.writeGet(role, 8, 0, 1);
	}
	
	@PostMapping("")
	public Object post(@RequestBody Role role) {
//		Role role = new Role(1, "23", "32");
//		return ResponseUtil.writeBad();
		return ResponseUtil.writePost(role);
	}
}
