package io.blog.model;

import kong.unirest.HttpResponse;

public class ResponseDto {
	private String apiType;
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
