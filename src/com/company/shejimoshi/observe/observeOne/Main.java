package com.company.shejimoshi.observe.observeOne;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-13 19:47
 */
public class Main {

  public static void main(String[] args) {
    Gper gper = new Gper("测试");
    Teacher tom = new Teacher("tom");
    Teacher jack = new Teacher("jack");
    gper.addObserver(tom);
    gper.addObserver(jack);
    //业务代码
    Question question = new Question();
    question.setUserName("stude");
    question.setContent("dfdfdf");
    gper.pulishQuestion(question);
  }
}
