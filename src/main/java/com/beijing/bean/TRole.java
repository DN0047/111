package com.beijing.bean;


import java.util.Objects;

public class TRole {

  private long id;
  private String name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TRole)) return false;
    TRole tRole = (TRole) o;
    return id == tRole.id &&
            Objects.equals(name, tRole.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
