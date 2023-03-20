package io.blog.util.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogExceptionHandler {

	private final Logger LOGGER = LoggerFactory.getLogger(BlogExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		
		LOGGER.info(e.getMessage());
		LOGGER.info("ExceptionHandler 호출");
		
		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "400");
		map.put("message", "에러 발생");
		
		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
}
