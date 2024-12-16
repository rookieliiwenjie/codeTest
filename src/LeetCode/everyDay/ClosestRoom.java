package LeetCode.everyDay;

import java.util.*;

public class ClosestRoom {
    /**
     * 一个酒店里有 n 个房间，这些房间用二维整数数组 rooms 表示，其中 rooms[i] = [roomIdi, sizei]
     * 表示有一个房间号为 roomIdi 的房间且它的面积为 sizei 。每一个房间号 roomIdi 保证是 独一无二 的。
     * <p>
     * 同时给你 k 个查询，用二维数组 queries 表示，其中 queries[j] = [preferredj, minSizej] 。
     * 第 j 个查询的答案是满足如下条件的房间 id ：
     * <p>
     * 房间的面积 至少 为 minSizej ，且
     * abs(id - preferredj) 的值 最小 ，其中 abs(x) 是 x 的绝对值。
     * 如果差的绝对值有 相等 的，选择 最小 的 id 。如果 没有满足条件的房间 ，答案为 -1 。
     * <p>
     * 请你返回长度为 k 的数组 answer ，其中 answer[j] 为第 j 个查询的结果。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
     * 输出：[3,-1,3]
     * 解释：查询的答案如下：
     * 查询 [3,1] ：房间 3 的面积为 2 ，大于等于 1 ，且号码是最接近 3 的，为 abs(3 - 3) = 0 ，所以答案为 3 。
     * 查询 [3,3] ：没有房间的面积至少为 3 ，所以答案为 -1 。
     * 查询 [5,2] ：房间 3 的面积为 2 ，大于等于 2 ，且号码是最接近 5 的，为 abs(3 - 5) = 2 ，所以答案为 3 。
     *
     * @param rooms
     * @param queries
     * @return
     */
    public static void main(String[] args) {
        ClosestRoom closestRoom = new ClosestRoom();
//        int rooms[][] = {{2, 2}, {1, 2}, {3, 2}};
//        int queries[][] = {{3, 1}, {3, 3}, {5, 2}};
//        [[1,4],[2,3],[3,5],[4,1],[5,2]]
//        queries =
//[[2,3],[2,4],[2,5]]
//        输出
//                [2,1,-1]
//        预期结果
//                [2,1,3]
        int rooms[][] = {{1, 4}, {2, 3}, {3, 5}, {4, 1}, {5, 2}};
        int queries[][] = {{2, 3}, {2, 4}, {2, 5}};
        int res[] = closestRoom.closestRoom(rooms, queries);
        System.out.println(Arrays.toString(res));
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int ans[] = new int[queries.length];
        //对rooms从大到小排序，房间号也是从小到大
        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int i = 0;
        for (int qu[] : queries) {
            int preferred = qu[0], minSize = qu[1];
            int min = -1;
            for (int room[] : rooms) {
                //如果小于min说明后面的也小跳出
                if (room[1] < minSize) {
                    break;
                }
                if (min != -1 && Math.abs(room[0] - preferred) > Math.abs(min - preferred)) {
                    continue;
                }
                if (min == -1 || Math.abs(room[0] - preferred) < Math.abs(min - preferred)
                        || (Math.abs(room[0] - preferred) == Math.abs(min - preferred) && room[0] < min)) {
                    min = room[0];
                }
            }
            ans[i] = min;
            i++;
        }
        return ans;

    }
    /**
     * 方法一：离线算法
     * 提示 1
     *
     * 如果我们可以将给定的房间和询问重新排序，那么是否可以使得问题更加容易解决？
     *
     * 提示 2
     *
     * 我们可以将房间以及询问都看成一个「事件」，如果我们将这些「事件」按照大小（房间的 size 或者询问的 minSize）进行降序排序，那么：
     *
     * 如果我们遇到一个表示房间的「事件」，那么可以将该房间的 roomId 加入某一「数据结构」中；
     * 如果我们遇到一个表示询问的「事件」，那么需要在「数据结构」中寻找与 preferred 最接近的 roomId。
     * 提示 3
     *
     * 你能想出一种合适的「数据结构」吗？
     *
     * 思路与算法
     *
     * 我们使用「有序集合」作为提示中的「数据结构」。
     *
     * 根据提示 2，我们将每一个房间以及询问对应一个「事件」，放入数组中进行降序排序。随后我们遍历这些「事件」：
     *
     * 如果我们遇到一个表示房间的「事件」，那么将该该房间的 roomId 加入「有序集合」中；
     * 如果我们遇到一个表示询问的「事件」，那么答案即为「有序集合」中与询问的 preferred
     * 最接近的那个 roomId。在大部分语言的「有序集合」的 API 中，
     * 提供了例如「在有序集合中查找最小的大于等于 x 的元素」或者「在有序集合中查找最小的严格大于 x 的元素」
     * ，我们可以利用这些 API 找出「有序集合」中与 preferred 最接近的两个元素，其中一个小于 preferred
     * ，另一个大于等于 preferred。通过比较这两个元素，我们即可得到该询问对应的答案。
     * 细节
     *
     * 如果不同类型的「事件」的位置相同，那么我们应当按照先处理表示房间的「事件」，再处理表示询问的「事件」，这是因为房间的 size 只要大于等于询问的 minSize 就是满足要求的。
     *

     */
    class Event implements Comparable<Event> {
        int type, size, id, origin;

        public Event(int type, int size, int id, int origin) {
            this.type = type;
            this.size = size;
            this.id = id;
            this.origin = origin;
        }

        @Override
        public int compareTo(Event that) {
            // 自定义比较函数，按照事件的 size 降序排序
            // 如果 size 相同，优先考虑房间
            if (this.size != that.size) {
                return Integer.compare(that.size, this.size);
            } else {
                return Integer.compare(this.type, that.type);
            }
        }
    }

    class Solution {
        public int[] closestRoom(int[][] rooms, int[][] queries) {
            int m = rooms.length;
            int n = queries.length;

            // 创建事件列表，存储房间和询问事件
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                // 房间事件
                events.add(new Event(0, rooms[i][1], rooms[i][0], i));
            }
            for (int i = 0; i < n; ++i) {
                // 询问事件
                events.add(new Event(1, queries[i][1], queries[i][0], i));
            }
            // 对事件列表进行排序
            Collections.sort(events);
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            // 使用 TreeSet 存储房间 roomId 的有序集合
            TreeSet<Integer> valid = new TreeSet<>();
            for (Event event : events) {
                if (event.type == 0) {
                    // 房间事件，将 roomId 加入有序集合
                    valid.add(event.id);
                } else {
                    // 询问事件，查找最近的房间
                    Integer higher = valid.ceiling(event.id);
                    Integer lower = valid.floor(event.id);
                    int dist = Integer.MAX_VALUE;

                    // 查找最小的大于等于 preferred 的元素
                    if (higher != null && higher - event.id < dist) {
                        dist = higher - event.id;
                        ans[event.origin] = higher;
                    }
                    // 查找最大的严格小于 preferred 的元素
                    if (lower != null && event.id - lower <= dist) {
                        ans[event.origin] = lower;
                    }
                }
            }

            return ans;
        }
    }

    public int[] closestRoom2(int[][] rooms, int[][] queries) {
        // 按照 size 从大到小排序
        Arrays.sort(rooms, (a, b) -> (b[1] - a[1]));

        int q = queries.length;
        Integer[] queryIds = new Integer[q];
        Arrays.setAll(queryIds, i -> i);
        // 按照 minSize 从大到小排序
        Arrays.sort(queryIds, (i, j) -> queries[j][1] - queries[i][1]);

        int[] ans = new int[q];
        Arrays.fill(ans, -1);
        TreeSet<Integer> roomIds = new TreeSet<>();
        int j = 0;
        for (int i : queryIds) {
            int preferredId = queries[i][0];
            int minSize = queries[i][1];
            while (j < rooms.length && rooms[j][1] >= minSize) {
                roomIds.add(rooms[j][0]);
                j++;
            }

            int diff = Integer.MAX_VALUE;
            Integer floor = roomIds.floor(preferredId);
            if (floor != null) {
                diff = preferredId - floor; // 左边的差
                ans[i] = floor;
            }
            Integer ceiling = roomIds.ceiling(preferredId);
            // 右边的差更小
            if (ceiling != null && ceiling - preferredId < diff) {
                ans[i] = ceiling;
            }
        }
        return ans;
    }



}
