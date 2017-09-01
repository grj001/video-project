package com.zhiyou100.video.model;

/**  
* @ClassName: FrontResult  
* @Description: TODO
* @author lyb  
* @date 2017年8月29日  下午7:22:25
*  
*/
public class FrontResult {

	private Boolean success;
	private String message;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "FrontResult [success=" + success + ", message=" + message + "]";
	}
	
}
