package com.company.LaoHan.ListDemo;

/**
 * Created by lwj32 on 2020/7/1.
 */
public class SingListDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "1", "1");
        HeroNode heroNode4 = new HeroNode(4, "4", "4");
        HeroNode heroNode3 = new HeroNode(3, "3", "3");
        HeroNode heroNode2 = new HeroNode(2, "2", "2");
        //HeroNode heroNode5 = new HeroNode(2, "2", "2");

        SingList singList = new SingList();
        /*singList.addOrderBy(heroNode);
        singList.addOrderBy(heroNode2);
        singList.addOrderBy(heroNode3);
        singList.addOrderBy(heroNode4);*/
        singList.add2(heroNode);
        singList.add2(heroNode2);
        singList.add2(heroNode3);
        singList.add2(heroNode4);
        //原来的
        //System.out.println("heroNode2 = " + singList.show(););
        // singList.addOrderBy(heroNode5);
        //singList.show();
        singList.reversetList(singList.head);
        singList.show();
        System.out.println("singList = " +singList.getLenght(singList.head));
        System.out.println("singList.getReverIndex(3,singList.head) = " + singList.getReverIndex(5,singList.head));
    }
}

class SingList {
    HeroNode head = new HeroNode(0, "", "");
    /**倒数第k个节点的数/
     * 
     */
    public static HeroNode getReverIndex(int k ,HeroNode head){
        if(head.next==null){
            return null;
        }
        int x = getLenght(head) - k;
        if(x<0){
            return null;
        }
        HeroNode cur = head.next;
        while (x>0){
            cur = cur.next;
            x--;
        }
        return cur;
        
    }
    /**
     * 获取链表的个数
     */
    public static int getLenght(HeroNode head) {
        int lenght = 0;

        if (head.next == null) {
            return lenght;
        }
        HeroNode cur = head.next;
        while (cur != null) {

            lenght++;
            cur = cur.next;
        }
        return lenght;
    }

    /**
     * 单列表反转
     * 1.将原来列表的每一个值进行取出
     * 2.建立一个新的列表
     * 3.将原来列表的每一个放到新链表的第一个位置
     * 4.取完原来链表以后将原来链表的head.next指向新链表的第一个节点
     *
     * @param heroNode
     */
    public static void reversetList(HeroNode heroNode) {
        if (heroNode.next == null || heroNode.next.next == null) {
            return;
        }
        HeroNode reverNode = new HeroNode(0, "", "");
        //定义一个辅助的指针帮助我们遍历原来的
        HeroNode cur = heroNode.next;
        HeroNode next = null;//指向当前节点的下一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = reverNode.next;//将插入节点的next指向现在列表的第一个投节点
            reverNode.next = cur;//将cur插入到第一个节点
            cur = next;
        }
        //将
        heroNode.next = reverNode.next;
    }

    public void add(HeroNode heroNode) {
        //状态位主要因为头节点不能动
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                //将next指向当前节点
                break;
            }

            temp = temp.next;

        }
        //找到最后一个节点将heronode赋值给temp.next
        temp.next = heroNode;


    }

    public void add2(HeroNode heroNode) {
        //状态位主要因为头节点不能动
        HeroNode temp = head;
        int state = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.num == heroNode.num) {
                show();
                System.out.println(" id重复");
                state = 1;
                break;
            }
            if (temp.next.num > heroNode.num) {
                HeroNode temp2 = temp.next;
                temp.next = heroNode;
                heroNode.next = temp2;
                break;

            }
            temp = temp.next;

        }
        //找到最后一个节点将heronode赋值给temp.next
        if (state == 0) {
            temp.next = heroNode;

        }


    }

    public void addOrderBy(HeroNode heroNode) {
        //状态位主要因为头节点不能动
        HeroNode temp = head;
        int state = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.num == heroNode.num) {
                state = 1;
                break;
            }
            if (temp.next.num > heroNode.num) {

                break;

            }
            temp = temp.next;

        }
        //找到最后一个节点将heronode赋值给temp.next
        if (state == 0) {
            heroNode.next = temp.next;
            temp.next = heroNode;

        } else {
            System.out.println(" id重复");
        }


    }

    public void show() {
        //状态位主要因为头节点不能动
        if (head.next == null) {
            System.out.println("为空");
        }
        HeroNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            //将temp指向下一个节点
            temp = temp.next;

        }

    }
}