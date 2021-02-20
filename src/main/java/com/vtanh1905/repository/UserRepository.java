package com.vtanh1905.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vtanh1905.dto.user.UserDetailsDto;
import com.vtanh1905.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u")
	public Page<User> findAllPaging(Pageable pageable);

	@Query("SELECT new com.vtanh1905.dto.user.UserDetailsDto( u.id, u.email, u.fullname, u.password, u.avatar, u.phone, u.address, r.id, r.description ) FROM User u, Role r WHERE u.roleId = r.id")
	public Page<UserDetailsDto> findAllDetailsPaging(Pageable pageable);
}
