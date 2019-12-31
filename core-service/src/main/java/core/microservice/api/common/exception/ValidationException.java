package core.microservice.api.common.exception;

import core.microservice.api.response.MessageDetail;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private MessageDetail messageDetail;

    public ValidationException() {
        super("Validation exception");
        this.messageDetail = MessageDetail.builder().message("Validation exception").build();
    }

    public ValidationException(MessageDetail messageDetail) {
        super( messageDetail.getMessage());
        this.messageDetail = messageDetail;
    }

    public ValidationException(MessageDetail messageDetail, Throwable cause) {
        super(messageDetail.getMessage());
        this.messageDetail = messageDetail;
    }


    public MessageDetail getMessageDetail() {
        return messageDetail;
    }

}
