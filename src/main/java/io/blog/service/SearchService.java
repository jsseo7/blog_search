package io.blog.service;

public interface SearchService {
	public Object getTableByKeyword(String query, String sort, int page, int size);
}
