package org.abder;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootLabApplication.class)
@WebIntegrationTest({"server.port=9000"})
public class SpringBootLabApplicationTests {

    @Test
    public void contextLoads() {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:9000/hello/joe", String.class);
        Assertions.assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
        Assertions.assertThat(responseEntity.getBody()).isNotEmpty().isEqualTo("Hello there joe !");
    }

}
