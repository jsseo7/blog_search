package io.blog.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.blog.common.msg.ResMsg;
import io.blog.model.WordDto;
import io.blog.repository.WordRepository;
import io.blog.service.DbService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DbServiceImpl implements DbService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WordRepository wordRepository;

	public Boolean setSearchWord(String word) {
		try {
			
			if(word == null) {
				return false;
			}
			//wordRepository.setPopularWord(word);	
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	public Object getSearchWordTop10() {
		return wordRepository.getSearchWordTop10();
	}
}
