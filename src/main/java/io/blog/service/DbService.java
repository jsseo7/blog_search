package io.blog.service;

import io.blog.model.ResponseDto;

public interface DbService {
	public ResponseDto setSearchWord(String word) throws Exception;
	public ResponseDto getSearchWordTop10() throws Exception;
}
