package com.rizwanmushtaq.services;

import com.rizwanmushtaq.entities.Todo;

import java.util.List;

public interface TodoService {
  public List<Todo> getTodos();

  public Todo getTodoById(String id);

  public Todo createTodo(Todo todo);

  public Todo updateTodo(String id, Todo todo);

  public Todo deleteTodo(String id);
}
