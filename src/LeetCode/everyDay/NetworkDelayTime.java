package LeetCode.everyDay;

import java.util.*;
import java.util.function.Function;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
//        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
//        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
        int[][] times = {{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}};
//        int [][]times=
        int i = networkDelayTime.networkDelayTime(times, 5, 5);
        System.out.println(i);
    }

    /**
     * 有 n 个网络节点，标记为 1 到 n。
     * <p>
     * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，
     * 其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
     * <p>
     * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
     *
     * @param times
     * @param n
     * @param k
     * @return
     */


    public int networkDelayTime2(int[][] times, int n, int k) {
        // 构建图的邻接表
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // 使用优先队列存储 [到达节点的时间，节点]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k}); // 初始节点 k 的到达时间为 0

        // 距离数组，记录到每个节点的最短时间
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
//. Dijkstra 算法主循环
//        java
//                复制代码
//        while (!pq.isEmpty()) {
//            int[] curr = pq.poll();
//            int time = curr[0], node = curr[1];
//
//            if (time > dist[node]) continue; // 跳过非最优路径
//
//            if (graph.containsKey(node)) {
//                for (int[] neighbor : graph.get(node)) {
//                    int nextNode = neighbor[0], weight = neighbor[1];
//                    if (time + weight < dist[nextNode]) {
//                        dist[nextNode] = time + weight;
//                        pq.add(new int[]{dist[nextNode], nextNode});
//                    }
//                }
//            }
//        }
//        每次从优先队列中取出当前时间最短的节点 [time, node]。
//        如果当前时间大于记录的最短距离 dist[node]，说明此路径非最优，跳过。
//        遍历当前节点的所有邻居：
//        如果经过当前节点的路径比之前记录的路径更短，则更新邻居的最短距离，并将其加入优先队列。
//        关键逻辑：
//
//        只有在发现更短路径时，才更新 dist[nextNode] 和重新加入队列。
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];
            // 如果当前时间不是最优，跳过
            if (time > dist[node]) continue;

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    if (time + weight < dist[nextNode]) {
                        dist[nextNode] = time + weight;
                        pq.add(new int[]{dist[nextNode], nextNode});
                    }
                }
            }
        }

        // 找到所有节点中最大时间
        int maxTime = Arrays.stream(dist).skip(1).max().getAsInt(); // 跳过第 0 节点
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    List<List<int[]>> hashMap = new ArrayList<>();
    HashMap<Integer, Integer> integers = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 0; i < n; i++) {
            hashMap.add(i, new ArrayList<>());
            integers.put(i + 1, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            List<int[]> ints = hashMap.get(time[0] - 1);
            ints.add(new int[]{time[1], time[2]});
        }
        dsf(k, -1, 0);
        integers.put(k, 0);
        Integer max = integers.values().stream().max(Integer::compareTo).get();
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public void dsf(int code, int parent, int num) {
        List<int[]> nextInt = hashMap.get(code - 1);
        if (nextInt == null || (integers.get(code - 1) != null && integers.get(code - 1) != Integer.MAX_VALUE)) {
            return;
        }
        for (int[] intnum : nextInt) {
            if (parent == intnum[0]) {
                continue;
            }
            if (integers.containsKey(intnum[0])) {
                Integer min = integers.get(intnum[0]);
                if (min > intnum[1] + num) {
                    integers.put(intnum[0], intnum[1] + num);
                }
                dsf(intnum[0], code, intnum[1] + num);
                continue;
            }
            integers.put(intnum[0], intnum[1]);
            dsf(intnum[0], code, intnum[1] + num);
        }
    }
}
