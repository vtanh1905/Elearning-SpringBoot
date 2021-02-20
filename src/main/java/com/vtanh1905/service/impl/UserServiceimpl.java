package com.vtanh1905.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vtanh1905.dto.user.UserCreateDto;
import com.vtanh1905.dto.user.UserDetailsDto;
import com.vtanh1905.dto.user.UserUpdateDto;
import com.vtanh1905.entity.User;
import com.vtanh1905.repository.UserRepository;
import com.vtanh1905.service.UserService;
import com.vtanh1905.utils.HashPassword;

@Service
public class UserServiceimpl implements UserService {

	private UserRepository userRepository;

	public UserServiceimpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> findAllPaging(int indexPage, int maxRow, String orderById) {
		Sort sort = null;
		// Check OrderBy is not equal ASC OR DESC
		if (orderById.equalsIgnoreCase("DESC")) {
			sort = Sort.by("id").descending();
		} else {
			sort = Sort.by("id").ascending();
		}
		Pageable pageable = PageRequest.of(indexPage - 1, maxRow, sort);
		return userRepository.findAllPaging(pageable);
	}
	
	@Override
	public Page<UserDetailsDto> findAllDetailsPaging(int indexPage, int maxRow, String orderById) {
		Sort sort = null;
		// Check OrderBy is not equal ASC OR DESC
		if (orderById.equalsIgnoreCase("DESC")) {
			sort = Sort.by("id").descending();
		} else {
			sort = Sort.by("id").ascending();
		}
		Pageable pageable = PageRequest.of(indexPage - 1, maxRow, sort);
		return userRepository.findAllDetailsPaging(pageable);

	}

	@Override
	public User save(UserCreateDto userCreateDto) {
		userCreateDto.setPassword(HashPassword.execute(userCreateDto.getPassword()));
		return userRepository.save(userCreateDto.toEntity());
	}

	@SuppressWarnings("unused")
	@Override
	public User edit(UserUpdateDto userUpdateDto) {
		// Check : if id is null
		final Integer id = userUpdateDto.getId();
		if (id == null) {
			return null;
		}

		// Check: If id is not exist
		final User user = userRepository.findById(userUpdateDto.getId()).get();
		if (user == null) {
			return null;
		}

		// HashPassword if password is changed
		String newPassword = userUpdateDto.getPassword();
		if (newPassword != null) {
			newPassword = HashPassword.execute(newPassword);
		}
		userUpdateDto.setPassword(newPassword);

		return userRepository.save(userUpdateDto.toEntityWithDefaultValue(user));
	}

	@Override
	public boolean delete(Integer id) {
		// Check: If user don't type id
		if (id == null) {
			return false;
		}
		// Check: If id is not exist
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User findById(Integer id) {
		// Check: If user don't type id
		if (id == null) {
			return null;
		}
		// Check: If id is not exist
		try {
			return userRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}

	}

}
