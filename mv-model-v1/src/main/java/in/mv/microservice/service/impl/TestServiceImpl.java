package in.mv.microservice.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import core.microservice.api.response.ResponseModel;
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

	@Inject
	private RestTemplate restTemplate;
	
	@Value("${application-server-2}")
	private String APPLICATION_SERVER_2;

	@Override
	public ResponseModel testService(String userName) {

		LOGGER.info("TestService: testService");
		String url = new StringBuilder("http://")
				.append(APPLICATION_SERVER_2)
				.append("/test-controller/api/test")
				.append("?email=")
				.append(userName).toString();
		
		LOGGER.info("Making request to : " + url);
		
		ResponseModel response = restTemplate.getForObject(url, ResponseModel.class);
		return response;
	}

}
