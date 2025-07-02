package com.rizwanmushtaq.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Todo {
  private static int idCounter = 0;
  private int id;
  private String title;
  private String content;
  private String status;
  private String creationDate;

  public Todo() {
    this.setId(++idCounter);
    this.setTitle("default value");
    this.setContent("default content");
    this.setStatus("New");
    this.setCreationDate();
  }

  public Todo(String title, String content, String status) {
    this.setId(++idCounter);
    this.setTitle(title);
    this.setContent(content);
    this.setStatus(status);
    this.setCreationDate();
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    this.creationDate = LocalDateTime.now().format(formatter);
  }

  public int getId() {
    return id;
  }

  private void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", status='" + status + '\'' +
        ", creationDate=" + creationDate +
        '}';
  }
}
