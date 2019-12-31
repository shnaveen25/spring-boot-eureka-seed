package core.microservice.swagger;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
public interface CoreSwaggerConfig {
	
	public String CONTACT_NAME = "Naveen Heroorkar";
	public String CONTACT_URL = "";
	public String CONTACT_EMAIL = "sh.naveen25@gmail.com";
	
	public default ApiInfo apiInfo(String appTitle, String appDescription, String appVersion) {
		return new ApiInfoBuilder()
				.title(appTitle).description("\"" + appDescription + "\"")
				.version(appVersion)
				.contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL))
				.build();
	}
	
	public Docket api();
}
