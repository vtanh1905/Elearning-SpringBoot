package com.vtanh1905.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255)
	private String title;
	
	@Column(length = 255)
	private String url;
	
	@Column(name = "time_count")
	private Integer timeCount;
	
	@Column(name = "course_id")
	private Integer courseId;
	
	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Course course;
	
}
