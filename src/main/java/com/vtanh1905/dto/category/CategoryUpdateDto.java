package com.vtanh1905.dto.category;

import com.vtanh1905.dto.BaseDto;
import com.vtanh1905.entity.Category;

public class CategoryUpdateDto extends BaseDto<Category> {
	private Integer id;
	private String title;
	private String icon;
	
	public CategoryUpdateDto() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	
}
