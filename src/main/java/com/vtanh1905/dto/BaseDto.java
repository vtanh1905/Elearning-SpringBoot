package com.vtanh1905.dto;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;

public abstract class BaseDto<T_ENTITY> {
	
	protected Class<? extends T_ENTITY> clazz;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDto() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType)t;
		clazz = (Class) parameterizedType.getActualTypeArguments()[0];
	}
	
	public T_ENTITY toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, clazz);
	}
	
	public T_ENTITY toEntityWithDefaultValue(T_ENTITY entity) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.map(this, entity);
		return entity;
	}
	
	@SuppressWarnings("rawtypes")
	public BaseDto fromEntity(T_ENTITY entity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entity, BaseDto.class);
	}
}
