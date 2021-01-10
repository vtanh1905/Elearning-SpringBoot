package com.vtanh1905.utils;

import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

	public static class FormatResponseEntity extends ResponseEntity<Object> {

		public FormatResponseEntity(Object data, HttpStatus status) {
			super(formatData(data, status), status);
		}
		
		public FormatResponseEntity(Object data, int total, int skip, int limit,HttpStatus status) {
			super(formatData(data, total, skip, limit, status), status);
		}

		public static void mappingCommonField(HashMap<String, Object> hashMap, Object data, HttpStatus status) {
			// Check : if status code is 404, we will return error message
			if (status.toString().charAt(0) == '4') {
				hashMap.put("error", data);
			} else {
				hashMap.put("body", data);
			}
			
			hashMap.put("status", status.value());
			hashMap.put("timestamp", new Timestamp(System.currentTimeMillis()));
		}

		public static Object formatData(Object data, HttpStatus status) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			mappingCommonField(hashMap, data, status);
			return hashMap;
		}

		public static Object formatData(Object data, int total, int skip, int limit, HttpStatus status) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			mappingCommonField(hashMap, data, status);
			hashMap.put("total", total);
			hashMap.put("skip", skip);
			hashMap.put("limit", limit);
			return hashMap;
		}
	};

	public static Object writeGet(Object data) {
		return new FormatResponseEntity(data, HttpStatus.CREATED);
	}
	
	public static Object writeGet(Object data, int total, int skip, int limit) {
		return new FormatResponseEntity(data, total, skip, limit, HttpStatus.CREATED);
	}

	public static Object writePost(Object data) {
		return new FormatResponseEntity(data, HttpStatus.CREATED);
	}

	public static Object writePut(Object data) {
		return new FormatResponseEntity(data, HttpStatus.OK);
	}

	public static Object writeDelete(Object data) {
		return new FormatResponseEntity(data, HttpStatus.OK);
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
