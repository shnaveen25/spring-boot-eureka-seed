package core.microservice.api.common.exception;

import core.microservice.api.response.MessageDetail;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
public class BusinessProcessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private MessageDetail messageDetail;

    public BusinessProcessException() {
        super("Validation exception");
        this.messageDetail = MessageDetail.builder().message("Validation exception").build();
    }

    public BusinessProcessException(MessageDetail messageDetail) {
        super(messageDetail.getMessage());
        this.messageDetail = messageDetail;
    }

    public BusinessProcessException(MessageDetail messageDetail, Throwable cause) {
        super(messageDetail.getMessage(), cause);
        this.messageDetail = messageDetail;
    }

    public BusinessProcessException(MessageDetail messageDetail, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(messageDetail.getMessage(), cause, enableSuppression, writableStackTrace);
        this.messageDetail = messageDetail;
    }

    public MessageDetail getMessageDetail() {
        return messageDetail;
    }

}
