package realEstate_kk.dto.response;

import realEstate_kk.interfaces.Code;

public class CheckIdResponseDto {
	
	private Code code;
	private String data;
	
	public CheckIdResponseDto() {}
	
	public CheckIdResponseDto(Code code, String data) {
		this.code = code;
		this.data = data;
	}
	
	public Code getCode() {
		return code;
	}
	
	public void setCode(Code code) {
		this.code = code;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
	
}
