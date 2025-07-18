package com.rizwanmushtaq.dao;

import com.rizwanmushtaq.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {
  Logger logger = LoggerFactory.getLogger(TodoDao.class);
  private JdbcTemplate jdbcTemplate;

  public TodoDao(@Autowired JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    logger.info("TodoDao initialized with JdbcTemplate: {}", jdbcTemplate);
    // Create the todos table if it does not exist
    String createTableQuery = "CREATE TABLE IF NOT EXISTS todos ("
        + "id INT PRIMARY KEY, "
        + "title VARCHAR(255) NOT NULL, "
        + "content TEXT, "
        + "status VARCHAR(50) NOT NULL, "
        + "creationDate dateTime NOT NULL"
        + ")";
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Todo saveTodo(Todo todo) {
    String insertQuery = "INSERT INTO todos(id,title,content,status,creationDate) VALUES(?,?, ?, ?, ?)";
    int rowsEffected = jdbcTemplate.update(insertQuery,
        todo.getId(),
        todo.getTitle(),
        todo.getContent(),
        todo.getStatus(),
        todo.getCreationDate()
    );
    logger.info("Rows affected: {}", rowsEffected);
    return todo;
  }
}
