package com.rizwanmushtaq.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController extends ApiBaseController {
  @GetMapping("/todos")
  public String getTodos() {
    System.out.println("List of todos requested ---");
    return "List of todos";
  }
}

