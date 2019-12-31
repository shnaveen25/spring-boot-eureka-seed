package in.mv.microservice.response.code;

public enum FailuerCode {

	TEST_001("FAILED-TEST-001");

	private String failuerCode;
	FailuerCode(String failuerCode) {
		this.failuerCode = failuerCode;
	}
	public String getValue() {
		return failuerCode;
	}
}
