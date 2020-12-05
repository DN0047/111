package com.beijing.bean;


import java.util.ArrayList;
import java.util.List;

public class TPermission {

  private long id;
  private long pid;
  private String name;
  private String icon;
  private String url;
  public List<TPermission> children = new ArrayList<>();
  private boolean open;
  private boolean checked;

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public List<TPermission> getChildren() {
    return children;
  }

  public void setChildren(List<TPermission> children) {
    this.children = children;
  }

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
