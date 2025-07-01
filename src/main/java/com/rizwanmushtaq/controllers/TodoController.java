package com.rizwanmushtaq.controllers;

import com.rizwanmushtaq.models.Todo;
import com.rizwanmushtaq.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController extends ApiBaseController {
  @GetMapping("/todos")
  public List<Todo> getTodos() {
    return TodoService.getTodos();
  }

  @GetMapping("/todos/{id}")
  public Todo getTodoById(@PathVariable int id) {
    return TodoService.getTodoById(id);
  }

  @PostMapping("/todos/create")
  public Todo createTodo(@RequestBody Todo todo) {
    return TodoService.createTodo(todo);
  }

  @PutMapping("/todos/update")
  public Todo updateTodo(@RequestBody Todo todo) {
    return TodoService.updateTodo(todo);
  }

  @DeleteMapping("/todos/delete/{id}")
  public boolean deleteTodo(@PathVariable int id) {
    return TodoService.deleteTodo(id);
  }
}

