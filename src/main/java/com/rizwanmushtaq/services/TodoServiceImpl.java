//package com.rizwanmushtaq.services;
//
//import com.rizwanmushtaq.dao.TodoDao;
//import com.rizwanmushtaq.entities.Todo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TodoServiceImpl implements TodoService {
//  @Autowired
//  private TodoDao todoDao;
//
//  public List<Todo> getTodos() {
//    return todoDao.getAllTodos();
//  }
//
//  public Todo getTodoById(int id) {
//    return todoDao.getTodoById(id);
//  }
//
//  public Todo createTodo(Todo todo) {
//    return todoDao.saveTodo(todo);
//  }
//
//  public Todo updateTodo(int id, Todo todo) {
//    return todoDao.updateTodo(id, todo);
//  }
//
//  public Todo deleteTodo(int id) {
//    return todoDao.deleteTodoById(id);
//  }
//}
