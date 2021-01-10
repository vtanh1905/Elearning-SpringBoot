package com.vtanh1905.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 100)
	private String email;

	@Column(length = 100)
	private String fullname;

	@Column(length = 100)
	private String password;

	@Column(length = 255)
	private String avatar;

	@Column(length = 20)
	private String phone;

	@Column(length = 255)
	private String address;

	@Column(name = "role_id")
	private int role_id;

	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@OneToMany(mappedBy = "user")
	private Set<UserCourse> userCourses;
}
