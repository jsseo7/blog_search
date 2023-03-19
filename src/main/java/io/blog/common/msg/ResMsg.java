package io.blog.common.msg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResMsg {
	private int code = 200;
	private String msg;
	private Object resData;
	private String messageCode;
	private String messageInfo;
	private String transactionId;
	private String serverResTime;
	private Object[] messageArgument;

	private int total;

	public ResMsg(String msg, Object resData) {
		this.code = 200;
		this.msg = msg;
		this.resData = resData;
		this.total = this.setRows(resData);
	}

	public ResMsg(String msg, Object resData, String messageCode, String messageInfo) {
		this.code = 200;
		this.msg = msg;
		this.resData = resData;
		this.messageCode = messageCode;
		this.messageInfo = messageInfo;
		this.total = this.setRows(resData);
	}

	public ResMsg(String msg, Object resData, String messageCode) {
		this.code = 200;
		this.msg = msg;
		this.resData = resData;
		this.messageCode = messageCode;
		this.total = this.setRows(resData);
	}

	public ResMsg(String msg) {
		this.code = 200;
		this.msg = msg;
	}

	public ResMsg(int code, String msg, Object resData) {
		this.code = code;
		this.msg = msg;
		this.resData = resData;
		this.total = this.setRows(resData);
	}

	private int setRows(Object data) {
		int rows = 0;

		Boolean isList = data == null ? false : data.getClass().isArray() || data instanceof Collection;
		if (isList) {
			List<?> list = new ArrayList<>();
			if (data.getClass().isArray()) {
				list = Arrays.asList((Object[]) data);
			} else {
				list = new ArrayList<>((Collection<?>) data);
			}
			rows = list.size();
		}
		return rows;
	}
}
