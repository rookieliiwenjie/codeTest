package LeetCode.everyDay;

import java.util.LinkedList;

class MyHashMap {

    private LinkedList<Integer> list = new LinkedList<>();

    public MyHashMap() {
    }

    public void put(int key, int value) {
        list.add(key, value);
    }

    public int get(int key) {
        return list.get(key);
    }

    public void remove(int key) {
        list.remove(key);
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(5, 2);
        myHashMap.put(2, 3);
        System.out.println(myHashMap.get(1));
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
