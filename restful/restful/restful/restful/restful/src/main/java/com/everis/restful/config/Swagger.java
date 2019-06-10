package com.everis.restful.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket eventoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.everis.restful"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}

	
	private Predicate<String> regex(String string) {
		return Predicates.and(
				PathSelectors.regex("/api.*"),
				Predicates.not(PathSelectors.regex("/error.*")));
	}


	private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API GIT LAB")
                .description("\"Spring Boot REST API for Online Store\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("David Alexandre de Paula Dias Filho", "https://www.linkedin.com/in/david-alexandre-de-paula-dias-filho-54a96291", "david.paula.dias@everis.com"))
                .build();
	}
}
	
	
	



