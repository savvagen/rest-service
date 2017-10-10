package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(paths()).build();
    }

    private Predicate<String> paths() {
        return or(regex("/users/all"),
                regex("/users/find.*"),
                regex("/users/find"),
                regex("/users/add"),
                regex("/users/add.*"),
                regex("/users/remove.*"),
                regex("/hello"),
                regex("/user"),
                regex("/user.*"),
                regex("/testUser.*"),
                regex("/testUser/status.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("My Swagger API documentation")
                .description("My Swagger API documentation for automation QAis")
                .termsOfServiceUrl("http://rest-service.com")
                .contact("genchevskiy.gepur@gmail.com").license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    }


}
