package realEstate_kk.dto.request;

public class CheckIdRequestDto {

	private String id;
	
	public String getId () {
		return id;
		
	}

	public void setId(String id) {
		this.id = id;
	} 
	
	public boolean validId() {
		boolean valid = id.length() <= 20;
		return valid;
	}
	
}
