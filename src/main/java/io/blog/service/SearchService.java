package io.blog.service;

import io.blog.model.ResponseDto;

public interface SearchService {
	public ResponseDto getTableByKeyword(String query, String sort, int page, int size);
}
