package com.rizwanmushtaq.services;

import com.rizwanmushtaq.entities.Todo;
import com.rizwanmushtaq.exceptions.ResourceNotFoundException;
import com.rizwanmushtaq.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TodoServiceJPAImpl implements TodoService {
  @Autowired
  private TodoRepository todoRepository;

  @Override
  public List<Todo> getTodos() {
    return todoRepository.findAll();
  }

  @Override
  public Todo getTodoById(String id) {
    return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
        "Todo not found with id: " + id, HttpStatus.NOT_FOUND));
  }

  @Override
  public Todo createTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public Todo updateTodo(String id, Todo todo) {
    Todo existingTodo = todoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Todo not found with id: " + id, HttpStatus.NOT_FOUND));
    existingTodo.setTitle(todo.getTitle());
    existingTodo.setContent(todo.getContent());
    existingTodo.setCreationDate(todo.getCreationDate());
    existingTodo.setStatus(todo.getStatus());
    return todoRepository.save(existingTodo);
  }

  @Override
  public Todo deleteTodo(String id) {
    Todo existingTodo = todoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Todo not found with id " + id, HttpStatus.NOT_FOUND));
    todoRepository.delete(existingTodo);
    return existingTodo;
  }
}
