package io.blog.service;

public interface DbService {
	public Boolean setSearchWord(String word);
	public Object getSearchWordTop10();
}
