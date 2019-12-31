package core.microservice.api.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
@JsonPropertyOrder({ "success", "code", "message", "response" })
public class ResponseModel {

	private String code;
	private Object responseData;
	private String message;
	private boolean success;

	public static ResponseModelBuilder builder() {
		return new ResponseModelBuilder();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getresponse() {
		return responseData;
	}

	public void setresponse(Object response) {
		this.responseData = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static class ResponseModelBuilder {

		private String code;
		private Object responseData;
		private String message;
		private boolean success = true;

		public ResponseModelBuilder code(String code) {
			this.code = code;
			return this;
		}

		public ResponseModelBuilder responseData(Object responseData) {
			this.responseData = responseData;
			return this;
		}

		public ResponseModelBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ResponseModelBuilder success(boolean success) {
			this.success = success;
			return this;
		}

		public ResponseModel build() {
			ResponseModel response = new ResponseModel();
			response.setCode(this.code);
			response.setresponse(this.responseData);
			response.setMessage(this.message);
			response.setSuccess(this.success);
			return response;
		}

	}

	@Override
	public String toString() {
		return "ResponseModel [code=" + code + ", responseData=" + responseData + ", message=" + message + ", success="
				+ success + "]";
	}

}
