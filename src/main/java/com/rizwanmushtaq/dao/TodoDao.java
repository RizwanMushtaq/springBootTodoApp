package com.rizwanmushtaq.dao;

import com.rizwanmushtaq.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDao {
  Logger logger = LoggerFactory.getLogger(TodoDao.class);
  private JdbcTemplate jdbcTemplate;

  public TodoDao(@Autowired JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    logger.info("TodoDao initialized with JdbcTemplate: {}", jdbcTemplate);
    // Create the todos table if it does not exist
    String createTableQuery = "CREATE TABLE IF NOT EXISTS todos ("
        + "id INT PRIMARY KEY AUTO_INCREMENT, "
        + "title VARCHAR(255) NOT NULL, "
        + "content VARCHAR(500) NOT NULL, "
        + "status VARCHAR(50) NOT NULL, "
        + "creationDate DATETIME NOT NULL"
        + ")";
    jdbcTemplate.update(createTableQuery);
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Todo saveTodo(Todo todo) {
    String insertQuery = "INSERT INTO todos(title,content,status,creationDate) VALUES(?,?,?,?)";
    int rowsEffected = jdbcTemplate.update(insertQuery,
        todo.getTitle(),
        todo.getContent(),
        todo.getStatus(),
        todo.getCreationDate()
    );
    logger.info("Rows affected: {}", rowsEffected);
    return todo;
  }

  public Todo[] getAllTodos() {
    String selectQuery = "SELECT * FROM todos";
    Todo[] todos = jdbcTemplate.query(selectQuery, (rs, rowNum) -> {
      Todo todo = new Todo();
      todo.setId(rs.getInt("id"));
      todo.setTitle(rs.getString("title"));
      todo.setContent(rs.getString("content"));
      todo.setStatus(rs.getString("status"));
      todo.setCreationDate(rs.getTimestamp("creationDate").toLocalDateTime());
      return todo;
    }).toArray(Todo[]::new);
    logger.info("Retrieved Todos: {}", (Object) todos);
    return todos;
  }

  public Todo getTodoById(int id) {
    String selectQuery = "SELECT * FROM todos WHERE id = ?";
    Todo todo = jdbcTemplate.queryForObject(selectQuery, new Object[]{id}, (rs, rowNum) -> {
      Todo t = new Todo();
      t.setId(rs.getInt("id"));
      t.setTitle(rs.getString("title"));
      t.setContent(rs.getString("content"));
      t.setStatus(rs.getString("status"));
      t.setCreationDate(rs.getTimestamp("creationDate").toLocalDateTime());
      return t;
    });
    logger.info("Retrieved Todo: {}", todo);
    return todo;
  }

  public Todo updateTodo(Todo partialTodo, int id) {
    StringBuilder updateQuery = new StringBuilder("UPDATE todos SET ");
    List<Object> params = new ArrayList<>();
    if (partialTodo.getTitle() != null) {
      updateQuery.append("title = ?, ");
      params.add(partialTodo.getTitle());
    }
    if (partialTodo.getContent() != null) {
      updateQuery.append("content = ?, ");
      params.add(partialTodo.getContent());
    }
    if (partialTodo.getStatus() != null) {
      updateQuery.append("status = ?, ");
      params.add(partialTodo.getStatus());
    }
    if (partialTodo.getCreationDate() != null) {
      updateQuery.append("creationDate = ?, ");
      params.add(partialTodo.getCreationDate());
    }
    // Remove trailing comma and space
    if (params.size() > 0) {
      updateQuery.setLength(updateQuery.length() - 2);
    }
    updateQuery.append(" WHERE id = ?");
    params.add(id);
    int rowsAffected = jdbcTemplate.update(updateQuery.toString(), params.toArray());
    logger.info("Rows affected by update: {}", rowsAffected);
    return getTodoById(id);
  }

  public int deleteTodoById(int id) {
    String deleteQuery = "DELETE FROM todos WHERE id = ?";
    int rowsAffected = jdbcTemplate.update(deleteQuery, id);
    logger.info("Rows affected by delete: {}", rowsAffected);
    return id;
  }
}
