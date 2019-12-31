package in.mv.microservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import core.microservice.swagger.CoreSwaggerConfig;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Naveen Heroorkar
 *
 */
@EnableSwagger2
@Configuration
@PropertySource("classpath:swagger.properties")
public class SwaggerConfigImpl implements CoreSwaggerConfig{

	@Value("${app.title}")
	private String APP_TITLE;
	@Value("${app.description}")
	private String APP_DESCRIPTION;
	@Value("${app.version}")
	private String APP_VERSION;
	@Value("${base.package}")
	private String BASE_PACKAGE;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo(APP_TITLE, APP_DESCRIPTION, APP_VERSION))
				.tags(new Tag("TestControllet", "Test Controller"));
	}
}
