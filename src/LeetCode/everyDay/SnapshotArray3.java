package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 超时版本
 */
public class SnapshotArray3 {
    private int snapId = 0;
    List<List<Integer>> result = new ArrayList<>();
    private int length;

    public SnapshotArray3(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(0);
        }
        this.length = length;
        result.add(list);
    }

    public void set(int index, int val) {
        List<Integer> list = result.get(snapId);
        list.set(index, val);
    }
    public int snap() {
        List<Integer> newArrayList = new ArrayList<>(length);
        List<Integer> list = result.get(snapId);
        for (int i = 0; i <list.size() ; i++) {
            newArrayList.add(i, list.get(i));
        }
        snapId++;
        result.add(snapId, newArrayList);
        return snapId - 1;
    }
    public int get(int index, int snap_id) {
        List<Integer> list = result.get(snap_id);
        return list.get(index);

    }
}
