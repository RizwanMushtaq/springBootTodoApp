package com.rizwanmushtaq;

import com.rizwanmushtaq.dao.TodoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTodoAppApplication implements CommandLineRunner {
  Logger logger = LoggerFactory.getLogger(SpringBootTodoAppApplication.class);
  @Autowired
  private TodoDao todoDao;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootTodoAppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Spring Boot Todo App is running...");
  }
}
