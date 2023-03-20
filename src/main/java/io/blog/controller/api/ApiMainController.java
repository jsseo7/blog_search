package io.blog.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blog.service.DbService;
import io.blog.service.SearchService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ApiMainController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DbService dbService;

	@Autowired
	SearchService searchService;
	
	@GetMapping("/db/setSearchWord")
	public Boolean setSearchWord(String word) throws Exception{
		return dbService.setSearchWord(word.trim());
	}
	
	@GetMapping("/db/getSearchWordTop10")
	public Object getSearchWordTop10() throws Exception{		
		return dbService.getSearchWordTop10();
	}
	
	@GetMapping("/api/getTableByKeyword")
	public Object getTableByKeyword(String query, String sort, int page, int size) {
		return searchService.getTableByKeyword(query.trim(), sort, page, size);
	}
}
