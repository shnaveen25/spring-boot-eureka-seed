package core.microservice.api.common.exception;

import java.util.Optional;

import core.microservice.api.response.ResponseModel;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
public interface CoreExceptionHandler {

	public default ResponseModel exceptionHandeler(Exception exception) {
		ResponseModel errorJson = new ResponseModel();
		errorJson.setCode("SERVER-FAILED-500");
		errorJson.setMessage(Optional.ofNullable(exception.getMessage()).orElse("Internal server error"));
		errorJson.setSuccess(false);
		return errorJson;
	}
	
	public default ResponseModel businessProcessHandeler(BusinessProcessException exception) {
		ResponseModel errorJson = new ResponseModel();
		errorJson.setCode(Optional.ofNullable(exception.getMessageDetail().getCode()).orElse("FAILED-001"));
		errorJson.setMessage(Optional.ofNullable(exception.getMessageDetail().getMessage()).orElse("Business validation error"));
		errorJson.setSuccess(false);
		return errorJson;
	}
	
	public default ResponseModel validationHandeler(ValidationException exception) {	
		ResponseModel errorJson = new ResponseModel();
		errorJson.setCode(Optional.ofNullable(exception.getMessageDetail().getCode()).orElse("VALIDATION-FAILED-001"));
		errorJson.setMessage(Optional.ofNullable(exception.getMessageDetail().getMessage()).orElse("Unexpected validation error"));
		errorJson.setSuccess(false);
		return errorJson;
	}
}
