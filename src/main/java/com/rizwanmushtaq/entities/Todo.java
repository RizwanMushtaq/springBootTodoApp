package com.rizwanmushtaq.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todos")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "todo_id")
  private String id;
  @Column(name = "todo_title", length = 100, nullable = false)
  private String title;
  @Column(name = "todo_content", length = 500, nullable = false)
  private String content;
  @Column(name = "todo_status", length = 20, nullable = false)
  private String status;
  @Column(name = "todo_creation_date", nullable = false)
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
