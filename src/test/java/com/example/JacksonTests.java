package com.example;


import com.example.jakson.Status;
import com.example.jakson.TestUser;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


@SpringBootTest
public class JacksonTests {



    @Test
    public void getUser(){
        RestTemplate restTemplate = new RestTemplate();
        TestUser user = restTemplate.getForObject("http://localhost:8080/testUser/1", TestUser.class);

        System.out.println(user.toString());

        assertEquals(user.getId(), 1);
        assertEquals(user.getFirstName(), "Savva");


    }


    @Test
    public void testQuotes(){
        RestTemplate restTemplate = new RestTemplate();
        Status status = restTemplate.getForObject("http://localhost:8080/testUser/status/1", Status.class);

        System.out.println(status.toString());

        assertEquals(status.getStatus(), "exist");
        assertEquals(status.getValue().getFirstName(), "Savva");

    }








}
