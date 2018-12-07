package com.tva.bigbellyblog.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Comment {

  @Field("id")
  private String id;
  @Field("name")
  private String name;
  @Field("email")
  private String email;
  @Field("content")
  private String content;
  @Field("approve1")
  private Boolean approve1;
  @Field("approve2")
  private Boolean approve2;

  public Comment() {
    super();
  }

  public Comment(String id, String name, String email, String content, Boolean approve1, Boolean approve2) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.content = content;
    this.approve1 = approve1;
    this.approve2 = approve2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Boolean getApprove1() {
    return approve1;
  }

  public void setApprove1(Boolean approve1) {
    this.approve1 = approve1;
  }

  public Boolean getApprove2() {
    return approve2;
  }

  public void setApprove2(Boolean approve2) {
    this.approve2 = approve2;
  }

}
