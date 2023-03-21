package io.blog.model;

import io.swagger.annotations.ApiModelProperty;

public class ResponseDto {
	
	@ApiModelProperty(value="검색 API 타입", example = "kakao", required = true)
	private String apiType;

	@ApiModelProperty(value="검색 결과", required = true)
	private String resData;
	
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
}
