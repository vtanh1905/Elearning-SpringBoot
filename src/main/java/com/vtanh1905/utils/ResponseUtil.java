package com.vtanh1905.utils;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

	public static class FormatResponseEntity extends ResponseEntity<Object> {

		public FormatResponseEntity(Object data, HttpStatus status) {
			super(formatData(data, status), status);
		}

		public FormatResponseEntity(Object data, int total, int limit, HttpStatus status) {
			super(formatData(data, total, limit, status), status);
		}

		public static void mappingCommonField(HashMap<String, Object> hashMap, Object data, HttpStatus status) {
			hashMap.put("status", status.value());
			hashMap.put("timestamp", new Timestamp(System.currentTimeMillis()));
			// Check : if status code is 404, we will return error message
			if (status.toString().charAt(0) == '4') {
				hashMap.put("error", data);
			} else {
				hashMap.put("body", data);
			}
		}

		public static Object formatData(Object data, HttpStatus status) {
			HashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
			mappingCommonField(hashMap, data, status);
			return hashMap;
		}

		public static Object formatData(Object data, int totalPages, int totalElements, HttpStatus status) {
			HashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
			mappingCommonField(hashMap, data, status);
			hashMap.put("totalPages", totalPages);
			hashMap.put("totalElements", totalElements);
			return hashMap;
		}
	};

	public static Object writeGet(Object data) {
		try {
			return new FormatResponseEntity(data, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeBad();
	}

	public static <T> Object writeGetPagination(Page<T> page) {
		try {

			return new FormatResponseEntity(page.getContent(), page.getTotalPages(), page.getNumberOfElements(),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeBad();
	}

	public static Object writePost(Object data) {
		try {
			return new FormatResponseEntity(data, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return writeBad();
	}

	public static Object writePut(Object data) {
		try {
			return new FormatResponseEntity(data, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return writeBad();
	}

	public static Object writeDelete(Object data) {
		try {
			return new FormatResponseEntity(data, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return writeBad();
	}

	public static Object writeBad() {
		return new FormatResponseEntity("400 Bad Request", HttpStatus.BAD_REQUEST);
	}

	public static Object writeBad(String msg) {
		return new FormatResponseEntity(msg, HttpStatus.BAD_REQUEST);
	}

	public static Object writeForbidden() {
		return new FormatResponseEntity("403 Forbidden", HttpStatus.FORBIDDEN);
	}

	public static Object writeForbidden(String msg) {
		return new FormatResponseEntity(msg, HttpStatus.FORBIDDEN);
	}
}
