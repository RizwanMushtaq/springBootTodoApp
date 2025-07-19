package com.rizwanmushtaq.dao;

import com.rizwanmushtaq.models.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TodoDaoRowMapper implements RowMapper {
  @Override
  public Todo mapRow(ResultSet result, int rowNum) throws SQLException {
    Todo todo = new Todo();
    todo.setId((int) result.getInt("id"));
    todo.setTitle((String) result.getString("title"));
    todo.setContent((String) result.getString("content"));
    todo.setStatus((String) result.getString("status"));
    todo.setCreationDate((Date) result.getDate("creationDate"));
    return todo;
  }
}
