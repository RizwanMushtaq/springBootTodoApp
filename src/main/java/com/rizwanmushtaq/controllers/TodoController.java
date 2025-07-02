package com.rizwanmushtaq.controllers;

import com.rizwanmushtaq.models.Todo;
import com.rizwanmushtaq.services.TodoService;
import com.rizwanmushtaq.utils.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController extends ApiBaseController {
  Logger logger = LoggerFactory.getLogger(TodoController.class);

  @GetMapping("/todos")
  public List<Todo> getTodos() {
    return TodoService.getTodos();
  }

  @GetMapping("/todos/{id}")
  public ResponseEntity<Object> getTodoById(@PathVariable int id) {
    Todo todo = TodoService.getTodoById(id);
    return todo != null ?
        ResponseEntity.ok(todo) :
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ErrorResponse("Todo with ID " + id + " not found"));
  }

  @PostMapping("/todos/create")
  public Todo createTodo(@RequestBody Todo todo) {
    logger.info("Create Todo");
    return TodoService.createTodo(todo);
  }

  @PutMapping("/todos/update")
  public Todo updateTodo(@RequestBody Todo todo) {
    return TodoService.updateTodo(todo);
  }

  @DeleteMapping("/todos/delete/{id}")
  public ResponseEntity<Object> deleteTodo(@PathVariable int id) {
    Todo todo = TodoService.deleteTodo(id);
    return todo != null ?
        ResponseEntity.ok(todo) :
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ErrorResponse("Todo with ID " + id + " not found"));
  }
}

