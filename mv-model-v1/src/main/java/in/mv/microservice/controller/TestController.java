package in.mv.microservice.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import core.microservice.api.common.exception.BusinessProcessException;
import core.microservice.api.common.exception.ValidationException;
import core.microservice.api.response.ResponseModel;
import in.mv.microservice.response.code.SuccessCode;
import in.mv.microservice.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
@Api(tags = {"TestControllet"})
@RestController
@RequestMapping(value = "/test-controller")
public class TestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	private static final String TEST_API = "/api/test";

	@Inject
	private TestService testService;

	@RequestMapping(value = TEST_API, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Sample get method for testing",response = ResponseEntity.class)
	public ResponseEntity<ResponseModel> testMethod(HttpServletRequest request, @RequestParam("email") String userName) {

		try {
			LOGGER.info("TestController : testMethod {}", userName);
			ResponseModel response = ResponseModel.builder()
					.code(SuccessCode.TEST_001.getValue())
					.responseData(testService.testService(userName).getresponse())
					.build();
			return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
		} catch (BusinessProcessException | ValidationException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}
