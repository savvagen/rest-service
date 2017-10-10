package com.example;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



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


}