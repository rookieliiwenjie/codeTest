package LeetCode.everyDay;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class ExamRoom {
    private int N;
    private TreeSet<Integer> occupiedSeats;

    public ExamRoom(int N) {
        this.N = N;
        this.occupiedSeats = new TreeSet<>();
    }

    public int seat() {
        if (occupiedSeats.isEmpty()) {
            // 如果没有人坐，坐在座位0
            occupiedSeats.add(0);
            return 0;
        }

        int seatToTake = Integer.MAX_VALUE;
        int dis = 0;
        Integer first = occupiedSeats.first();
        if (first != 0) {
            dis = first;
            seatToTake = 0;
        }
        //计算每段的距离
        Integer pre = null;
        for (Integer seat : occupiedSeats) {
            if (pre != null) {
                int currdis = (seat - pre) / 2;
                int currSent = pre + currdis;
                if (currdis > dis) {
                    dis = currdis;
                    seatToTake = currSent;
                }
            }
            pre = seat;
        }
        Integer last = occupiedSeats.last();
        if (last != N - 1) {
            int curdis = N - last - 1;
            if (dis < curdis) {
                dis = curdis;
                seatToTake = N - 1;
            }
        }
        //计算
        // 将该座位标记为已占用
        occupiedSeats.add(seatToTake);
        return seatToTake;
    }

    public int seatchat() {
        if (occupiedSeats.isEmpty()) {
            // 如果没有人坐，坐在座位0
            occupiedSeats.add(0);
            return 0;
        }
        int maxDistance = 0;
        int seatToTake = 0;
        // 检查座位0到第一个已占座的距离
        Integer firstSeat = occupiedSeats.first();
        if (firstSeat != 0) {
            int distance = firstSeat; // 0到第一个已占座的距离
            if (distance > maxDistance) {
                maxDistance = distance;
                seatToTake = 0;
            }
        }

        // 检查每两个已占座位之间的空座位
        Integer prev = null;
        for (Integer currentSeat : occupiedSeats) {
            if (prev != null) {
                int distance = (currentSeat - prev) / 2;
                int candidateSeat = prev + distance;
                if (distance > maxDistance) {
                    maxDistance = distance;
                    seatToTake = candidateSeat;
                }
            }
            prev = currentSeat;
        }

        // 检查最后一个已占座到最后一号座位的距离
        Integer lastSeat = occupiedSeats.last();
        if (lastSeat != N - 1) {
            int distance = N - 1 - lastSeat;
            if (distance > maxDistance) {
                maxDistance = distance;
                seatToTake = N - 1;
            }
        }

        // 将该座位标记为已占用
        occupiedSeats.add(seatToTake);
        return seatToTake;
    }

    public void leave(int p) {
        // 让座位p的学生离开
        occupiedSeats.remove(p);
    }

    class ExamRoom2 {
        int n;
        TreeSet<Integer> seats;
        PriorityQueue<int[]> pq;

        public ExamRoom2(int n) {
            this.n = n;
            this.seats = new TreeSet<Integer>();
            this.pq = new PriorityQueue<int[]>((a, b) -> {
                int d1 = a[1] - a[0], d2 = b[1] - b[0];
                return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
            });
        }

        public int seat() {
            if (seats.isEmpty()) {
                seats.add(0);
                return 0;
            }
            int left = seats.first(), right = n - 1 - seats.last();
            while (seats.size() >= 2) {
                int[] p = pq.peek();
                if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                    int d = p[1] - p[0];
                    if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                        break;
                    }
                    pq.poll();
                    pq.offer(new int[]{p[0], p[0] + d / 2});
                    pq.offer(new int[]{p[0] + d / 2, p[1]});
                    seats.add(p[0] + d / 2);
                    return p[0] + d / 2;
                }
                pq.poll(); // leave 函数中延迟删除的区间在此时删除
            }
            if (right > left) { // 最右的位置更优
                pq.offer(new int[]{seats.last(), n - 1});
                seats.add(n - 1);
                return n - 1;
            } else {
                pq.offer(new int[]{0, seats.first()});
                seats.add(0);
                return 0;
            }
        }

        public void leave(int p) {
            if (p != seats.first() && p != seats.last()) {
                int prev = seats.lower(p), next = seats.higher(p);
                pq.offer(new int[]{prev, next});
            }
            seats.remove(p);
        }
    }


}
