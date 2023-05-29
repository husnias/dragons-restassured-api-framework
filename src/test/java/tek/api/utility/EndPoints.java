package tek.api.utility;

public enum EndPoints {
	TOKEN_GENERATION("/api/token"),
	TOKEN_VERIFY("/api/token/verify"),
	GET_ALL_ACCOUNTS("/api/accounts/get-all-accounts"),
	GET_ACCOUNT("/api/accounts/get-account");
	
	private String value;
	
	EndPoints(String value){
		this.value = value;
		
	}
	public String getValue() {
		return this.value;
	}
	
	

}
