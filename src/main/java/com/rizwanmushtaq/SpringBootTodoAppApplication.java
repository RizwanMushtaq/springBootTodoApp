package com.rizwanmushtaq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTodoAppApplication implements CommandLineRunner {
  Logger logger = LoggerFactory.getLogger(SpringBootTodoAppApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringBootTodoAppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("Spring Boot Todo App is running...");
  }
}
