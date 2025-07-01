package com.rizwanmushtaq.models;

public class Todo {
  private static int idCounter = 0;
  private int id;
  private String title;
  private String content;
  private String status;

  public Todo() {
    this.setId(++idCounter);
    this.setTitle("default value");
    this.setContent("default content");
    this.setStatus("New");
  }

  public Todo(String title, String content, String status) {
    this.setId(++idCounter);
    this.setTitle(title);
    this.setContent(content);
    this.setStatus(status);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
        '}';
  }
}
