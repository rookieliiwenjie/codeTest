package com.company.LaoHan.ListDemo;

/**
 * Created by lwj32 on 2020/7/1.
 */
public class HeroNode {
    public int num;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode(int num,String name,String nickName){
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}
