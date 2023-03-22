package io.blog.service.impl;


import org.springframework.stereotype.Service;

import io.blog.model.ResponseDto;
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
		
	public ResponseDto getTableByKeyword(String query, String sort, int page, int size) {

		ResponseDto responseDto = new ResponseDto();

		HttpResponse<String> result = kakaoApiConnection(query, sort, page, size);	
		responseDto.setApiType("kakao");
		
		if(result.getStatus() != 200) {
			result = naverApiConnection(query, sort, page, size);
			if(result.getStatus() != 200) {
				responseDto.setCode("fail");
				responseDto.setResData(result.getBody());				
				return responseDto;
			}
			responseDto.setApiType("naver");
		}
		
		responseDto.setCode("success");
		responseDto.setResData(result.getBody());
		return responseDto;
	}
	
	public HttpResponse<String> kakaoApiConnection(String query, String sort, int page, int size) {
				
		StringBuilder responseData = new StringBuilder();
		responseData.append(KAKAO_URL);			

		if(query != null) {
			responseData.append("?query=" + query);
		}
		if(sort != null) {
			sort = sort.equals("sim") ? sort = "accuracy" : sort;
			sort = sort.equals("date") ? sort = "recency" : sort;
			responseData.append("&sort=" + sort);
		}			
		if(page != 0) {
			responseData.append("&page=" + page);
		}			
		if(size != 0) {
			responseData.append("&size=" + size);
		}		
		
		return Unirest.get(responseData.toString()).header("Authorization", KAKAO_SECRETKEY).asString();							
	}

	public HttpResponse<String> naverApiConnection(String query, String sort, int page, int size) {
		
		StringBuilder responseData = new StringBuilder();
		responseData.append(NAVER_URL);
			
		if(query != null) {
			responseData.append("?query=" + query);
		}
		if(sort != null) {
			sort = sort.equals("accuracy") ? sort = "sim" : sort;
			sort = sort.equals("recency") ? sort = "date" : sort;
			responseData.append("&sort=" + sort);
		}			
		if(page != 0) {
			responseData.append("&start=" + page*size);
		}			
		if(size != 0) {
			responseData.append("&display=" + size);
		}		

		return Unirest.get(responseData.toString()).header("X-Naver-Client-Id", NAVER_ID).header("X-Naver-Client-Secret", NAVER_SECRETKEY).asString();		
	}
}
