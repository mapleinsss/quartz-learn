package org.maple.quartz1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling 任务多写在这
public class Quartz1Application {

    public static void main(String[] args) {
        SpringApplication.run(Quartz1Application.class, args);
    }

}
