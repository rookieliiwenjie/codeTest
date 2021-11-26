package com.company.shejimoshi.observe.observeOne;

import java.util.Observable;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-13 22:41
 */
public class Gper extends Observable {

  private String name;

  public Gper(String name) {
    this.name = name;
  }

  public void pulishQuestion(Question question) {
    System.out.println("name = " + name + "" + question);
    setChanged();
    notifyObservers(question);
  }
}
