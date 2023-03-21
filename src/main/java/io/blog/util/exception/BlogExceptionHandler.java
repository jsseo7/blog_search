package io.blog.util.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class BlogExceptionHandler {

	private final Logger LOGGER = LoggerFactory.getLogger(BlogExceptionHandler.class);

	@ExceptionHandler(value = NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handle404Exception(NoHandlerFoundException e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;

		// LOGGER.info(e.getMessage());
		LOGGER.error("###########################");
		LOGGER.error(e.toString());
		LOGGER.error("###########################");

		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "404");
		map.put("message", e.toString());
		
		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}

	@ExceptionHandler(value = DataAccessException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ResponseEntity<Map<String, String>> handleDataAccessException(DataAccessException e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_GATEWAY;

		// LOGGER.info(e.getMessage());
		LOGGER.error("###########################");
		LOGGER.error(e.toString());
		LOGGER.error("###########################");

		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "502");
		map.put("message", e.toString());

		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		// LOGGER.info(e.getMessage());
		LOGGER.error("###########################");
		LOGGER.error(e.toString());
		LOGGER.error("###########################");

		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "500");
		map.put("message", e.toString());

		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
}
