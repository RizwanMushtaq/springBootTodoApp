package com.rizwanmushtaq;

import com.rizwanmushtaq.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTodoAppApplication {
  @Autowired
  private TodoDao todoDao;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootTodoAppApplication.class, args);
  }
}
