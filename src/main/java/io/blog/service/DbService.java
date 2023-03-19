package io.blog.service;

import io.blog.common.msg.ResMsg;

public interface DbService {
	public Boolean setSearchWord(String searchWord);
	public Object getSearchWordTop10();
}
