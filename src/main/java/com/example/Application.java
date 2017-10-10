package com.example;



import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }






    //This is for running some request to server after starting of the application;

    /*@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }


    @Bean
    public CommandLineRunner run(RestTemplate template) throws Exception{
        return args -> {
            Status status = template.getForObject(
                    "http://localhost:8080/testUser/status/1", Status.class);
            System.out.println(status.toString());
        };
    }*/










    //You can build swagger docs for requests that will be for all controllers
    /*@Bean
    public Docket postsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.groupName("public-api")
                .apiInfo(apiInfo()).select().paths(paths()).build();

        docket.globalResponseMessage(RequestMethod.GET, ImmutableList.of(new ResponseMessageBuilder()
                .code(400)
                .message("Bad Request")
                .responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error")
                .responseModel(new ModelRef("Error")).build()));

        return docket;

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
    }*/


}