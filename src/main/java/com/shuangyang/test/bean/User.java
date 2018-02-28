package com.shuangyang.test.bean;

/**
 * Created by 罗高杨 on 2017-7-11.
 */
public class User {
  private String id;
  private String name;
  private int age;

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}