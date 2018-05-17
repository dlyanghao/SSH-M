package com.yanghao.pojo;


public class Orders {

  private long id;
  private String product;
  private double price;

  private User user;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Orders{" +
            "id=" + id +
            ", product='" + product + '\'' +
            ", price=" + price +
            ", user=" + user +
            '}';
  }
}
