package com.rizwanmushtaq;

import com.rizwanmushtaq.dao.TodoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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
//    Todo todo = new Todo("Learn Spring Boot", "Complete the Spring Boot " +
//        "tutorial", "In Progress", Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()));
//    logger.info("Creating a new Todo: {}", todo);
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
//    todoDao.saveTodo(todo);
    todoDao.getTodoById(5);
//    todoDao.deleteTodoById(3);
//    Todo updatedTodo = new Todo();
//    updatedTodo.setTitle("Updated Title");
//    todoDao.updateTodo(updatedTodo, 4);
    todoDao.getAllTodos();
  }
}
