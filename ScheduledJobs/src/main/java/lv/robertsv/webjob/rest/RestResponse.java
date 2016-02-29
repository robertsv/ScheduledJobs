package lv.robertsv.webjob.rest;

public enum RestResponse {
	OK(200, "Ok");
	
	RestResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	private int status;
	private String msg;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
