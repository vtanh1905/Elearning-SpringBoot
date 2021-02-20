package com.vtanh1905.dto.role;

import com.vtanh1905.dto.BaseDto;
import com.vtanh1905.entity.Role;

public class RoleUpdateDto extends BaseDto<Role> {
	private Integer id;
	private String name;
	private String description;
	
	public RoleUpdateDto() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
