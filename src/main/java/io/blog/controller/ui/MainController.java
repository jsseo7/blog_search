package io.blog.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="화면")
@Controller
public class MainController {

	@ApiOperation(value="index 화면")
	@GetMapping("/")
	public String index() throws Exception {
		return "index";
	}

	@ApiOperation(value="블로그 메인 화면")
	@GetMapping("/main/blog")
	public String blog() throws Exception {
		return "main/blog";
	}
}
