package com.company.shejimoshi.observe.observeOne;

import java.util.Observable;
import java.util.Observer;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-13 22:43
 */
public class Teacher implements Observer {
  private String stuName;

  public Teacher(String stuName) {
    this.stuName = stuName;
  }

  @Override
  public void update(Observable o, Object arg) {
    Gper gper = (Gper) o;

  }
}
