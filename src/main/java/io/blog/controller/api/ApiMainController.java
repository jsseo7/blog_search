package io.blog.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.blog.common.msg.ResMsg;
import io.blog.service.DbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping("/db")
public class ApiMainController {

	@Autowired
	DbService dbService;

	@GetMapping("/setSearchWord")
	public Boolean setSearchWord(String searchWord) throws Exception{
		return dbService.setSearchWord(searchWord);
	}
	
	@GetMapping("/getSearchWordTop10")
	public Object getSearchWordTop10() throws Exception{		
		return dbService.getSearchWordTop10();
	}
}
