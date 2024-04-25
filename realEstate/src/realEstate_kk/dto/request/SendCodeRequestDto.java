package realEstate_kk.dto.request;

public class SendCodeRequestDto {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean validEmail() {
		boolean vaild = email.length() <= 50;
		return vaild;
	}
	
}
