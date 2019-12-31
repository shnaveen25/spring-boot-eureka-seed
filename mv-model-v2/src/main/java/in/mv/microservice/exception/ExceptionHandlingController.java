package in.mv.microservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import core.microservice.api.common.exception.BusinessProcessException;
import core.microservice.api.common.exception.CoreExceptionHandler;
import core.microservice.api.common.exception.ValidationException;
import core.microservice.api.response.ResponseModel;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
@RestControllerAdvice
public class ExceptionHandlingController implements CoreExceptionHandler {

	private Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseModel> exceptionHandeler(HttpServletRequest req, Exception exception) {
		LOGGER.error("Exception : {} ", exception.getMessage());
		return new ResponseEntity<ResponseModel>(exceptionHandeler(exception), HttpStatus.NOT_IMPLEMENTED);
	}

	@ExceptionHandler(BusinessProcessException.class)
	public ResponseEntity<ResponseModel> businessProcessHandeler(HttpServletRequest req, BusinessProcessException exception) {
		LOGGER.error("BusinessProcessException Exception : {}", exception.getMessageDetail().toString());
		return new ResponseEntity<ResponseModel>(businessProcessHandeler(exception), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ResponseModel> validationHandeler(HttpServletRequest req, ValidationException exception) {
		LOGGER.error("ValidationException Exception : {}", exception.getMessageDetail().toString());
		return new ResponseEntity<ResponseModel>(validationHandeler(exception), HttpStatus.BAD_REQUEST);
	}

}
