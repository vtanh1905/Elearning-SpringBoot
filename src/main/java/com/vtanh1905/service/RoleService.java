package com.vtanh1905.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vtanh1905.dto.role.RoleCreateDto;
import com.vtanh1905.dto.role.RoleUpdateDto;
import com.vtanh1905.entity.Role;

public interface RoleService {
	public List<Role> findAll();
	public Page<Role> findAllPaging(int indexPage, int maxRow, String orderById);
	public Role save(RoleCreateDto roleCreateDto);
	public Role edit(RoleUpdateDto roleUpdateDto);
	public boolean delete(Integer id);
	public Role findById(Integer id);
}
