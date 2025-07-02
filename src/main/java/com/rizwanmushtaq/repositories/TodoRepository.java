package com.rizwanmushtaq.repositories;

import com.rizwanmushtaq.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class TodoRepository {
  private static List<Todo> todos = new ArrayList<>();
  private static Logger logger = LoggerFactory.getLogger(TodoRepository.class);

  public static List<Todo> getTodos() {
    return todos;
  }

  public static Todo getTodoById(int id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        return todo;
      }
    }
    return null;
  }

  public static Todo createTodo(Todo todo) {
    todos.add(todo);
    logger.info("updated Todo List" + todos);
    return todo;
  }

  public static Todo updateTodo(Todo todo) {
    for (int i = 0; i < todos.size(); i++) {
      if (todos.get(i).getId() == todo.getId()) {
        todos.set(i, todo);
        return todo;
      }
    }
    return null;
  }

  public static Todo deleteTodo(int id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        todos.remove(todo);
        return todo;
      }
    }
    return null;
  }
}
