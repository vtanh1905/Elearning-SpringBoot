package com.vtanh1905.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_courses")
public class UserCourse{
		
	@EmbeddedId
	private UserCourseKey id;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id",  insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id",  insertable = false, updatable = false)
	private Course course;
	
	@Column(name = "role_id")
	private int role_id;
}
