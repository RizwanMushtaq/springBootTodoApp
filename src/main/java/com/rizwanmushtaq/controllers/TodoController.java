package com.rizwanmushtaq.controllers;

import com.rizwanmushtaq.entities.Todo;
import com.rizwanmushtaq.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController extends ApiBaseController {
  Logger logger = LoggerFactory.getLogger(TodoController.class);
  @Autowired
  private TodoService todoService;

  @GetMapping("/todos")
  public ResponseEntity<List<Todo>> getTodos() {
    return ResponseEntity.ok(todoService.getTodos());
  }

  @GetMapping("/todos/{id}")
  public ResponseEntity<Todo> getTodoById(@PathVariable String id) {
    return ResponseEntity.ok(todoService.getTodoById(id));
  }

  @PostMapping("/todos/create")
  public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
    if (todo.getCreationDate() == null) {
      todo.setCreationDate(new java.util.Date());
    }
    logger.info("Created Todo {}", todo.toString());
    return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(todo));
  }

  @PutMapping("/todos/update/{id}")
  public ResponseEntity<Todo> updateTodo(@PathVariable String id,
                                         @RequestBody Todo todo) {
    return ResponseEntity.ok(todoService.updateTodo(id, todo));
  }

  @DeleteMapping("/todos/delete/{id}")
  public ResponseEntity<Todo> deleteTodo(@PathVariable String id) {
    return ResponseEntity.ok(todoService.deleteTodo(id));
  }
}

