package com.example.clover.introtoandroid.models;

/**
 * Created by rachel.antion on 12/15/17.
 */

public class SimpleItem {
  private String title, description;

  public SimpleItem(String title, String description){
    this.title = title;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
