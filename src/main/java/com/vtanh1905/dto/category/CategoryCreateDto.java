package com.vtanh1905.dto.category;

import com.vtanh1905.dto.BaseDto;
import com.vtanh1905.entity.Category;

public class CategoryCreateDto extends BaseDto<Category> {
	private String title;
	private String icon;
	
	public CategoryCreateDto() {
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
