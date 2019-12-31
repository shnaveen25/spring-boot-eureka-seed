package in.mv.microservice.response.code;

public enum SuccessCode {

	TEST_001("TEST-001");

	private String successCode;
	SuccessCode(String successCode) {
		this.successCode = successCode;
	}
	public String getValue() {
		return successCode;
	}
}
