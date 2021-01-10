package com.vtanh1905.entity;

import java.sql.Timestamp;
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
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 255)
	private String title;
	
	@Column(length = 255)
	private String image;
	
	@Column(name = "letures_count")
	private int letures_count;
	
	@Column(name = "hour_count")
	private int hour_count;
	
	@Column(name= "view_count")
	private int view_count;
	
	@Column
	private double price;
	
	@Column
	private int discount;
	
	@Column(name = "promotion_price")
	private double promotion_price;
	
	@Column(length = 255)
	private String description;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "category_id")
	private int category_id;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="timestamp", nullable = false,
//		    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
//	private Date timestamp = new Date();
	@Column(name = "last_update")
	private Timestamp last_update;
	
	@ManyToOne
	@JoinColumn(name="category_id", insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(mappedBy = "course")
	private Set<Video> videos;
		
	@ManyToOne
	@JoinColumn(name="id", insertable = false, updatable = false)
	private Target target;
	
	@OneToMany(mappedBy = "course")
	private Set<UserCourse> userCourses;
}
