package io.blog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.blog.repository.WordRepository;
import io.blog.service.DbService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DbServiceImpl implements DbService{
	
	@Autowired
	WordRepository wordRepository;

	public Boolean setSearchWord(String word) {
		try {
			if(word == null) {
				return false;
			}
			
			wordRepository.runMysql();
			wordRepository.setPopularWord(word);	
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	public Object getSearchWordTop10() {
		return wordRepository.getSearchWordTop10();
	}
}
