package com.rizwanmushtaq.models;

import java.util.Date;

public class Todo {
  private int id;
  private String title;
  private String content;
  private String status;
  private Date creationDate;

  public Todo() {
  }

  public Todo(String title, String content, String status, Date creationDate) {
    this.setTitle(title);
    this.setContent(content);
    this.setStatus(status);
    this.setCreationDate(creationDate);
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
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
        ", creationDate=" + creationDate +
        '}';
  }
}
