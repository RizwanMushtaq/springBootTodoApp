package com.rizwanmushtaq.services;

import com.rizwanmushtaq.models.Todo;

import java.util.List;

public interface TodoService {
  public List<Todo> getTodos();

  public Todo getTodoById(int id);

  public Todo createTodo(Todo todo);

  public Todo updateTodo(int id, Todo todo);

  public Todo deleteTodo(int id);
}
