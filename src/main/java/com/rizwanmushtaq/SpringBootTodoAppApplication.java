package com.rizwanmushtaq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTodoAppApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootTodoAppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Spring Boot Todo App is running...");
  }
}
