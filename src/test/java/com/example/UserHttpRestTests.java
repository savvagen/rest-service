package com.example;



import com.example.jakson.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserHttpRestTests {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;




    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        restTemplate = new TestRestTemplate();
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/hello",
                String.class)).contains("{\"id\":1,\"content\":\"Hello, World!\"}");
        //In case when text is returning
    }


    @Test
    public void userShouldReturnDefaultMessage() throws Exception {
        restTemplate = new TestRestTemplate();
        TestUser user = restTemplate.getForObject("http://localhost:" + port + "/testUser/1", TestUser.class);
        assertThat(user.getId(), equalTo(1));
        assertThat(user.getFirstName(), equalTo("Savva"));

    }




}
