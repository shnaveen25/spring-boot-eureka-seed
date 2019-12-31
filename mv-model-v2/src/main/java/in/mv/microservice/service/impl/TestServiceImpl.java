package in.mv.microservice.service.impl;

import java.util.Date;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import core.microservice.api.common.exception.ValidationException;
import core.microservice.api.response.MessageDetail;
import in.mv.microservice.dto.TestDTO;
import in.mv.microservice.response.code.FailuerCode;
import in.mv.microservice.service.TestService;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
@Singleton
@Service
@PropertySource({ "classpath:app-client.properties" })
public class TestServiceImpl implements TestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

	@Override
	public TestDTO testService(String userName) {
		LOGGER.info("Model V2 : TestServiceImpl");
		TestDTO result;
		if(null != userName && !userName.trim().isEmpty()) {
			result = new TestDTO();
			result.setTime(new Date());
			result.setMessage(new StringBuilder("Hi ").append(userName).append(", Response is coming form Model V2 Server").toString());
		} else {
			MessageDetail errorMessage = MessageDetail.builder()
					.message("username Should not be empty")
					.code(FailuerCode.TEST_001.getValue()).build();
        	throw new ValidationException(errorMessage);
		}
		return result;
	}

}
