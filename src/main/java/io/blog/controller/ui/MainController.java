package io.blog.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/main/blog")
	public String blog() {
		return "main/blog";
	}
}
