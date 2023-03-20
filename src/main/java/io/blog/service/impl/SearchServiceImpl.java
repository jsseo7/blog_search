package io.blog.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.blog.service.SearchService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

	private final String KAKAO_URL = "https://dapi.kakao.com/v2/search/blog";	
	private final String KAKAO_SECRETKEY = "KakaoAK c71c96f80628b4c6cd9a8491bf10f052";
	
	private final String NAVER_URL = "https://openapi.naver.com/v1/search/blog.json";	
	private final String NAVER_ID = "NizjeMzYMtrvW5ZqtuwI";	
	private final String NAVER_SECRETKEY = "6Jt2m8TJmd";
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Object getTableByKeyword(String query, String sort, int page, int size) {
	
		HttpResponse<String> result = connection("kakao", query, sort, page, size);
		
		if(result.getStatus() != 200) {
			result = connection("naver", query, sort, page, size);
		}
		
		return result.getBody();
	}
	
	public HttpResponse<String> connection(String type, String query, String sort, int page, int size) {
				
		StringBuilder responseData = new StringBuilder();

		if(type.equals("naver")) {
			responseData.append(NAVER_URL);
		} else {
			responseData.append(KAKAO_URL);			
		}
		
		if(query != null) {
			responseData.append("?query=" + query);
		}
		if(sort != null) {
			responseData.append("&sort=" + sort);
		}			
		if(page != 0) {
			responseData.append("&page=" + page);
		}			
		if(size != 0) {
			responseData.append("&size=" + size);
		}		
		
		if(type.equals("naver")) {
			return Unirest.get(responseData.toString()).header("X-Naver-Client-Id", NAVER_ID).header("X-Naver-Client-Secret", NAVER_SECRETKEY).asString();		
		} else {
			return Unirest.get(responseData.toString()).header("Authorization", KAKAO_SECRETKEY).asString();					
		}
	}
}
