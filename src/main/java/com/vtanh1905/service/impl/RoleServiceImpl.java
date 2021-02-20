package com.vtanh1905.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vtanh1905.dto.role.RoleCreateDto;
import com.vtanh1905.dto.role.RoleUpdateDto;
import com.vtanh1905.entity.Role;
import com.vtanh1905.repository.RoleRepository;
import com.vtanh1905.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(RoleCreateDto roleCreateDto) {
		return roleRepository.save(roleCreateDto.toEntity());
	}

	@Override
	public Role edit(RoleUpdateDto roleUpdateDto) {
		// Check: If user don't type id
		final Integer id = roleUpdateDto.getId();
		if (id == null) {
			return null;
		}
		// Check: If id is not exist
		final Role role = roleRepository.findById(id).get();
		if (role == null) {
			return null;
		}
		return roleRepository.save(roleUpdateDto.toEntityWithDefaultValue(role));
	}

	@Override
	public boolean delete(Integer id) {
		// Check: If user don't type id
		if (id == null) {
			return false;
		}
		// Check: If id is not exist
		try {
			roleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Role findById(Integer id) {
		// Check: If user don't type id
		if (id == null) {
			return null;
		}
		// Check: If id is not exist
		try {
			return roleRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<Role> findAllPaging(int indexPage, int maxRow, String orderById) {
		Sort sort = null;
		// Check OrderBy is not equal ASC OR DESC
		if (orderById.equalsIgnoreCase("DESC")) {
			sort = Sort.by("id").descending();
		}else {
			sort = Sort.by("id").ascending();
		}
		Pageable pageable = PageRequest.of(indexPage - 1, maxRow, sort);
		return roleRepository.findAllPaging(pageable);
	}

}
