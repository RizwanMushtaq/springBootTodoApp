package com.rizwanmushtaq.services;

import com.rizwanmushtaq.models.Todo;
import com.rizwanmushtaq.repositories.TodoRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class TodoService {
  public static List<Todo> getTodos() {
    List<Todo> todos = new ArrayList<>();
    return TodoRepository.getTodos();
  }

  public static Todo getTodoById(int id) {
    return TodoRepository.getTodoById(id);
  }

  public static Todo createTodo(Todo todo) {
    return TodoRepository.createTodo(todo);
  }

  public static Todo updateTodo(Todo todo) {
    return TodoRepository.updateTodo(todo);
  }

  public static boolean deleteTodo(int id) {
    return TodoRepository.deleteTodo(id);
  }
}
