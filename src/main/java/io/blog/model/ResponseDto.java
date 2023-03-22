package io.blog.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ResponseDto {
		
	@ApiModelProperty(value="검색 성공 여부", example = "success", required = true)
	private String code;

	@ApiModelProperty(value="검색 API 타입", example = "kakao", required = true)
	private String apiType;

	@ApiModelProperty(value="검색 결과", required = true)
	private String resData;
	
	@ApiModelProperty(value="검색 결과 리스트", required = true)
	private List<WordDto> wordDto;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	
	public String getResData() {
		return resData;
	}
	public void setResData(String resData) {
		this.resData = resData;
	}
	
	public List<WordDto> getWordDto() {
		return wordDto;
	}

	public void setWordDto(List<WordDto> wordDto) {
		this.wordDto = wordDto;
	}
}
