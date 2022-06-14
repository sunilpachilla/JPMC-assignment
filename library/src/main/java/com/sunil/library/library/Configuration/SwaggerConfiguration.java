package com.sunil.library.library.Configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*@Configuration
@EnableSwagger2
@Profile(!prod)
public class SwaggerConfiguration {
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/student/*"))//USes ant design pattern and only for the mentioned URL//restrictiosn on URL 
				.apis( RequestHandlerSelectors.basePackage("com.sunil.library.library.*"))//To only look in this package//this excluddes modules
				.build()
				.apiInfo(apiDetails());

				
	}
private ApiInfo apiDetails() {
		
		//Constructor is taking bunch of arguments as mentioned beow
		return new ApiInfo(
				"Student book API",//Changes the name of the APi documentaio
				"Sample API for student details",
				"1.0",
				"free to use",
				new springfox.documentation.service.Contact("sunil pachilla", "http://javanrains.io", "abc@.com"),
				"API License",
				"http://javabrains.io",
				Collections.emptyList());
	}

}	
*/

