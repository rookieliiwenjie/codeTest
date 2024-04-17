package LeetCode.day5_2020_12_14_findMinArrowShots;

import java.util.Arrays;

/**
 * @Author rookie.li
 * @create 2020/12/14
 */
public class FindMinArrowShots {
    /*在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，
    气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
    一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
    若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
    弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
    给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
    示例 1：
    输入：points = [[10,16],[2,8],[1,6],[7,12]]
    输出：2
    解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
    示例 2：
    输入：points = [[1,2],[3,4],[5,6],[7,8]]
    输出：4
    示例 3：
    输入：points = [[1,2],[2,3],[3,4],[4,5]]
    输出：2
    示例 4：
    输入：points = [[1,2]]
    输出：1
    示例 5：
    输入：points = [[2,3],[2,3]]
    输出：1
    提示：
            0 <= points.length <= 104
    points[i].length == 2
            -231 <= xstart <xend <= 231 - 1*/
    public static void main(String[] args) {
        //int[][] points = {{1, 2}, {3, 4}, {5, 6} ,{7, 8}};
        //int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{0, 9}, {0, 6}, {2, 9}, {2, 8}, {3, 9}, {3, 8}, {3, 9}, {6, 8}, {7, 12}, {9, 10}};
        //int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println("minArrowShots = " + minArrowShots);
    }

    /**
     *  public static void main(String[] args) {
     *         SearchRequestDTO searchRequestDTO = new SearchRequestDTO();
     *         OrderItemDTO orderItemDTO = new OrderItemDTO();
     *         orderItemDTO.setSort("asc");
     *         orderItemDTO.setKey("time");
     *         searchRequestDTO.setOrder(orderItemDTO);
     *         boolean sortFlag = false;
     *         List<HotProjectDTO> hotProjectDTOS = new ArrayList<>();
     *         HotProjectDTO hotProjectDTO = new HotProjectDTO();
     *         GemsCardResultDTO gemsCardResultDTO = new GemsCardResultDTO();
     *         gemsCardResultDTO.setLocationType("show");
     *         gemsCardResultDTO.setNextTime("15:00");
     *         //gemsCardResultDTO.setWaitTime("9");
     *         hotProjectDTO.setGemsCardResultDTO(gemsCardResultDTO);
     *         hotProjectDTOS.add(hotProjectDTO);
     *
     *
     *         HotProjectDTO hotProjectDTO2 = new HotProjectDTO();
     *         GemsCardResultDTO gemsCardResultDTO2 = new GemsCardResultDTO();
     *         gemsCardResultDTO2.setLocationType("show");
     *         gemsCardResultDTO2.setNextTime("13:00");
     *         gemsCardResultDTO2.setWaitTime("8");
     *         hotProjectDTO2.setGemsCardResultDTO(gemsCardResultDTO2);
     *         hotProjectDTOS.add(hotProjectDTO2);
     *
     *
     *         HotProjectDTO hotProjectDTO3 = new HotProjectDTO();
     *         GemsCardResultDTO gemsCardResultDTO3 = new GemsCardResultDTO();
     *         gemsCardResultDTO3.setLocationType("show");
     *         gemsCardResultDTO3.setNextTime("11:00");
     *         gemsCardResultDTO3.setWaitTime("9");
     *         hotProjectDTO3.setGemsCardResultDTO(gemsCardResultDTO3);
     *
     *         hotProjectDTOS.add(hotProjectDTO3);
     *
     *
     *         HotProjectDTO hotProjectDTO4 = new HotProjectDTO();
     *         GemsCardResultDTO gemsCardResultDTO4 = new GemsCardResultDTO();
     *         gemsCardResultDTO4.setLocationType("show");
     *         //gemsCardResultDTO4.setNextTime("12:00");
     *         //gemsCardResultDTO4.setWaitTime("3");
     *         hotProjectDTO4.setGemsCardResultDTO(gemsCardResultDTO4);
     *         hotProjectDTOS.add(hotProjectDTO4);
     *         OrderByTime(searchRequestDTO, false, "ddd", hotProjectDTOS);
     *         System.out.println("hotProjectDTOS = " + hotProjectDTOS.toString());
     *
     *
     *     }
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length <= 0) {
            return 0;
        }
        int num = 1;
        Arrays.sort(points, (o1, o2) -> {

            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(points[i]));
        }
        int max = points[0][1];
        //num==1是因为我们上来以后默认最少有一根箭
        for (int i = 1; i < points.length; ++i) {
            if (max < points[i][0]) {
                num++;
                max = points[i][1];
            }
        }
        return num;

    }

    public int findMinArrowShots2(int[][] points) {
        int length = points.length;
        if (length == 0) return 0;
        Arrays.sort(points, ((o1, o2) -> o1[1] > o2[1] ? 1 : -1));

        int pos = points[0][1];
        int ans = 1;
        for (int[] ballon : points) {
            if (ballon[0] > pos) {
                pos = ballon[1];
                ++ans;
            }
        }
        return ans;
    }


}
