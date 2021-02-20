package com.vtanh1905.dto.role;

import com.vtanh1905.dto.BaseDto;
import com.vtanh1905.entity.Role;

public class RoleCreateDto extends BaseDto<Role> {
	private String name;
	private String description;
	
	public RoleCreateDto() {
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

}
