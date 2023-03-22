package io.blog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.blog.model.ResponseDto;
import io.blog.repository.WordRepository;
import io.blog.service.DbService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DbServiceImpl implements DbService{
	
	@Autowired
	WordRepository wordRepository;

	public ResponseDto setSearchWord(String word) throws Exception {

		ResponseDto responseDto = new ResponseDto();

		try {
			if(word == null) {
				responseDto.setCode("fail");
				responseDto.setResData("조회한 단어가 없습니다.");
				return responseDto;
			}
			
			wordRepository.runMysql();
			wordRepository.setPopularWord(word);	

			responseDto.setCode("success");
			responseDto.setResData("검색어 목록에 저장되었습니다.");
		} catch (Exception e){
			responseDto.setCode("fail");
			responseDto.setResData(e.toString());
		}

		return responseDto;
	}
	
	public ResponseDto getSearchWordTop10() throws Exception{
		
		ResponseDto responseDto = new ResponseDto();

		try {			
			responseDto.setCode("success");
			responseDto.setResData("인기검색어가 조회되었습니다.");
			responseDto.setWordDto(wordRepository.getSearchWordTop10());
		} catch (Exception e) {
			responseDto.setCode("fail");
			responseDto.setResData(e.toString());	
		}
		
		return responseDto;
	}
}
