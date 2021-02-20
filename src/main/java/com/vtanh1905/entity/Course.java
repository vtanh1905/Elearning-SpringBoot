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
	private Integer id;
	
	@Column(length = 255)
	private String title;
	
	@Column(length = 255)
	private String image;
	
	@Column(name = "letures_count")
	private Integer leturesCount;
	
	@Column(name = "hour_count")
	private Integer hourCount;
	
	@Column(name= "view_count")
	private Integer viewCount;
	
	@Column
	private double price;
	
	@Column
	private Integer discount;
	
	@Column(name = "promotion_price")
	private double promotionPrice;
	
	@Column(length = 255)
	private String description;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "category_id")
	private Integer categoryId;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="timestamp", nullable = false,
//		    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
//	private Date timestamp = new Date();
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
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
