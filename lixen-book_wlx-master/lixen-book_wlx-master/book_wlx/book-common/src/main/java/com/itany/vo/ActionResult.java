package com.itany.vo;

import java.io.Serializable;

public class ActionResult implements Serializable{
	
	private String msg;
	
	private Integer status;
	
	private Object data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
