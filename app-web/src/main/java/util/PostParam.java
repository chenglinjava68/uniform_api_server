package util;

public class PostParam {
	private String message = "";
	
	public boolean checkParam() throws Exception{
		return true;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
