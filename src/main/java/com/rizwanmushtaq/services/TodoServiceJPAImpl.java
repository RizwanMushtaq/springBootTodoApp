package com.rizwanmushtaq.services;

import com.rizwanmushtaq.entities.Todo;
import com.rizwanmushtaq.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TodoServiceJPAImpl implements TodoService {
  @Autowired
  private TodoRepository todoRepository;

  @Override
  public List<Todo> getTodos() {
    List<Todo> todos = todoRepository.findAll();
    return todos;
  }

  @Override
  public Todo getTodoById(String id) {
    return null;
  }

  @Override
  public Todo createTodo(Todo todo) {
    return null;
  }

  @Override
  public Todo updateTodo(String id, Todo todo) {
    return null;
  }

  @Override
  public Todo deleteTodo(String id) {
    return null;
  }
}
