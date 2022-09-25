package com.example.restfull.restfull.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class Swaggerconfig {                                    
    public static final String TAG_1 = "PSS Reports";
    public static final String TAG_2 = "PSS Validations";

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())   
          .paths(PathSelectors.any())   
          .build()
          .apiInfo(apiInfo())
          .tags(new Tag(TAG_1, "Reports module"))
          .tags(new Tag(TAG_2, "Validation module"));
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("PSS Workflow API").version("1.0.0").build();
    }
}