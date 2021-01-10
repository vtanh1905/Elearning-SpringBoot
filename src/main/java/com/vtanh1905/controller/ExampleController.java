package com.vtanh1905.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
public class ExampleController {
	
	@GetMapping("")
	public Object get() {
		return new ResponseEntity<>("This is a example API", HttpStatus.OK);
	}
}
