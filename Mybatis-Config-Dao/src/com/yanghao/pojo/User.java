package com.yanghao.pojo;


import java.util.List;

public class User {

  private long id;
  private String username;
  private String password;
  private String email;
  private List<Orders> list;


  public List<Orders> getList() {
    return list;
  }

  public void setList(List<Orders> list) {
    this.list = list;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", list=" + list +
            '}';
  }
}
