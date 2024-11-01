package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 超时版本
 */
public class SnapshotArray {
    private int snapId = 0;
    HashMap<Integer, List<Integer>> result = new HashMap<>();
    private int length;
    private int version;
    HashMap<Integer, Integer> versionToSnapId = new HashMap<>();

    public SnapshotArray(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(0);
        }
        this.length = length;
        result.put(version, list);
    }

    public void set(int index, int val) {
        List<Integer> list = result.get(version);
        List<Integer> newArrayList = new ArrayList<>(length);
        for (int i = 0; i < list.size(); i++) {
            if (i == index) {
                newArrayList.add(i, val);
                continue;
            }
            newArrayList.add(i, list.get(i));
        }
        version++;
        result.put(version, newArrayList);
    }

    public int snap() {
        versionToSnapId.put(snapId, version);
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        Integer version = versionToSnapId.get(snap_id);
        List<Integer> list = result.get(version);
        return list.get(index);
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(3);
//        snapshotArray.set(1, 6);
//        int snap = snapshotArray.snap();
//        int snap1 = snapshotArray.snap();
//        snapshotArray.set(1, 19);
//        snapshotArray.set(0, 4);
//        int i = snapshotArray.get(2, snap1);
//        System.out.println(i);
//        int i1 = snapshotArray.get(2, snap);
//        int i2 = snapshotArray.get(0, snap1);
//        System.out.println(i1);
//        System.out.println(i2);

        snapshotArray.set(0, 5);
        int snap = snapshotArray.snap();
        snapshotArray.set(0, 6);
        System.out.println(snapshotArray.get(0, snap));

        //   System.out.println(snapshotArray.get(0, 0));
    }
}
