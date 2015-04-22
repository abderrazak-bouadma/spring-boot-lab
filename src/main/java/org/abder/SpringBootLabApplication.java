package org.abder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:git.properties"})
public class SpringBootLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLabApplication.class, args);
    }

}
