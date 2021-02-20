package com.vtanh1905.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vtanh1905.dto.user.UserCreateDto;
import com.vtanh1905.dto.user.UserDetailsDto;
import com.vtanh1905.dto.user.UserUpdateDto;
import com.vtanh1905.entity.User;

public interface UserService {
	public List<User> findAll();
	public Page<User> findAllPaging(int indexPage, int maxRow, String orderById);
	public Page<UserDetailsDto> findAllDetailsPaging(int indexPage, int maxRow, String orderById);
	public User save(UserCreateDto userCreateDto);
	public User edit(UserUpdateDto userUpdateDto);
	public boolean delete(Integer id);
	public User findById(Integer id);
}
