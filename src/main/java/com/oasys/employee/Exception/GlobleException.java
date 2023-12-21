package com.oasys.employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleException {
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object>salaryHandle(SalaryNotFoundException s1) {
		return new ResponseEntity<>(s1.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}
