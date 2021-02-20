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

import com.vtanh1905.dto.role.RoleCreateDto;
import com.vtanh1905.dto.role.RoleUpdateDto;
import com.vtanh1905.entity.Role;
import com.vtanh1905.service.RoleService;
import com.vtanh1905.utils.ResponseUtil;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	private RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping("")
	public Object get(@RequestParam(required = false, defaultValue = "1") int indexPage,
			@RequestParam(required = false, defaultValue = "10") int maxRow,
			@RequestParam(required = false, defaultValue = "ASC") String orderById) {
		return ResponseUtil.writeGetPagination(roleService.findAllPaging(indexPage, maxRow, orderById));
	}

	@PostMapping("")
	public Object post(@RequestBody RoleCreateDto roleCreateDto) {
		return ResponseUtil.writeGet(roleService.save(roleCreateDto));
	}

	@PutMapping("")
	public Object put(@RequestBody RoleUpdateDto roleUpdateDto) {
		Role result = roleService.edit(roleUpdateDto);
		if (result == null) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writePut(result);
	}

	@DeleteMapping("/{id}")
	public Object deleteById(@PathVariable Integer id) {
		if (roleService.delete(id) == false) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writeDelete("Delete Successfully");
	}

	@GetMapping("/no-pagination")
	public Object getNoPagination() {
		return ResponseUtil.writeGet(roleService.findAll());
	}

	@GetMapping("/{id}")
	public Object getById(@PathVariable Integer id) {
		Role result = roleService.findById(id);
		if (result == null) {
			return ResponseUtil.writeBad("Id isn't exist");
		}
		return ResponseUtil.writeGet(result);
	}
}
