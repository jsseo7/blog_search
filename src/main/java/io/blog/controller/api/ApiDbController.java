package io.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blog.model.ResponseDto;
import io.blog.service.DbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags="데이터베이스")
@RequiredArgsConstructor
@RestController
@RequestMapping("/db")
public class ApiDbController {

	@Autowired
	DbService dbService;

	@ApiOperation(value="검색어 목록 추가")
	@GetMapping("/setSearchWord")
	public ResponseDto setSearchWord(String word) throws Exception{
		return dbService.setSearchWord(word.trim());
	}

	@ApiOperation(value="인기 검색어 Top 10 조회")
	@GetMapping("/getSearchWordTop10")
	public ResponseDto getSearchWordTop10() throws Exception{		
		return dbService.getSearchWordTop10();
	}
}
