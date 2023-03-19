package io.blog.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import io.blog.controller.api.ApiMainController;
import io.blog.service.impl.DbServiceImpl;

@WebMvcTest(ApiMainController.class)
public class ApiMainControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DbServiceImpl dbService;
	
	@Test
	@DisplayName("DB 데이터 조회 테스트")
	void getDbTest() throws Exception{
		
//		given(dbService.getSearchWordTop10()).willReturn(
//				new ));
//		mockMvc.perform(
//				get(""))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath()).exists())
//		.andDo(print());
	
	}
}
