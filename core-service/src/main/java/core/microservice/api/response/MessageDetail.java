package core.microservice.api.response;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
public class MessageDetail {

	private String code;
	private String message;

	private MessageDetail() {

	}

	public static MessageDetailBuilder builder() {
		return new MessageDetailBuilder();
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}

	public static class MessageDetailBuilder {

		private String code;

		private String message;

		public MessageDetailBuilder message(String message) {
			this.message = message;
			return this;
		}

		public MessageDetailBuilder code(String code) {
			this.code = code;
			return this;
		}

		public MessageDetail build() {
			MessageDetail messageDetail = new MessageDetail();
			messageDetail.setMessage(this.message);
			messageDetail.setCode(this.code);
			return messageDetail;
		}

	}

	@Override
	public String toString() {
		return "MessageDetail [code=" + code + ", message=" + message + "]";
	}

}
