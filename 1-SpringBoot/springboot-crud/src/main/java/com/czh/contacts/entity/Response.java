package com.czh.contacts.entity;

/**
 * 定义通用返回体
 * @author caizh
 *
 */
public class Response {
	
	/**
	 * 成功代码
	 */
	public static int SUCCESS = 1;
	
	/**
	 * 失败代码
	 */
	public static int FAILED = -1;
	
	/**
	 * 空数据代码
	 */
	public static int EMPTY = 0;
	
	/**
	 * 返回码
	 */
	private int rtncode;
	
	/**
	 * 返回消息
	 */
	private String message;
	
	/**
	 * 返回体
	 */
	private Object body;
	
	public Response() {
	}
	
	public Response(int rtncode, String message, Object body) {
		super();
		this.rtncode = rtncode;
		this.message = message;
		this.body = body;
	}
	public Response(int rtncode, Object body) {
		super();
		this.rtncode = rtncode;
		this.body = body;
	}
	public int getRtncode() {
		return rtncode;
	}
	public void setRtncode(int rtncode) {
		this.rtncode = rtncode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Response [返回码=" + rtncode + ", 返回消息=" + message + ", 返回内容=" + body + "]";
	}
}
