package io.blog.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blog.service.DbService;
import io.blog.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags="검색")
@RequiredArgsConstructor
@RestController
@RequestMapping("/search")
public class ApiSearchController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SearchService searchService;
	
	@ApiOperation(value="블로그 검색")
	@GetMapping("/getTableByKeyword")
	public Object getTableByKeyword(String query, String sort, int page, int size) {
		return searchService.getTableByKeyword(query.trim(), sort, page, size);
	}
}
