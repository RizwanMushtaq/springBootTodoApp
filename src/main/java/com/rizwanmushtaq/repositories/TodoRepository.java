package com.rizwanmushtaq.repositories;

import com.rizwanmushtaq.exceptions.ResourceNotFoundException;
import com.rizwanmushtaq.models.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class TodoRepository {
  private static List<Todo> todos = new ArrayList<>();

  public static List<Todo> getTodos() {
    return todos;
  }

  public static Todo getTodoById(int id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        return todo;
      }
    }
    throw new ResourceNotFoundException("Todo not found with ID: " + id,
        HttpStatus.NOT_FOUND);
  }

  public static Todo createTodo(Todo todo) {
    todos.add(todo);
    return todo;
  }

  public static Todo updateTodo(int id, Todo todo) {
    for (Todo todoItem : todos) {
      if (todoItem.getId() == id) {
        todoItem.setTitle(todo.getTitle());
        todoItem.setContent(todo.getContent());
        todoItem.setStatus(todo.getStatus());
        return todoItem;
      }
    }
    throw new ResourceNotFoundException("Todo not found with ID: " + id,
        HttpStatus.NOT_FOUND);
  }

  public static Todo deleteTodo(int id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        todos.remove(todo);
        return todo;
      }
    }
    throw new ResourceNotFoundException("Todo not found with ID: " + id,
        HttpStatus.NOT_FOUND);
  }
}
