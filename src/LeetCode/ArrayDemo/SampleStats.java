package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/27 10:16 上午
 * @Description:
 */
public class SampleStats {
    public static void main(String[] args) {
//        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3510, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6718, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27870, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26256, 0, 0, 0, 0, 9586565, 0, 0, 0, 0, 0, 0, 0, 2333, 0, 0, 0, 0};
//        //int arr1[] = {0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        System.out.println("5/2 = " + 8 / 2); //8  9  10  4 5
//        System.out.println("6/2 = " + 5 / 2); //9 10 11 5 6
//        sampleStats(arr);

        System.out.println( Integer.valueOf(30).compareTo(20) > 0);
        //   sampleStats2(arr);
    }

    public static double[] sampleStats(int[] count) {
        double[] sample = new double[5];
        int countLength = count.length;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        long mean = 0;
        int numMax = 0;
        double numSum = 0;
        int total = Arrays.stream(count).sum();
        double mid = 0;
        long sum = 0;
        int pre = 0;
        for (int i = 0; i < countLength; i++) {
            int num = count[i];
            if (num > 0) {
                if (numMax < num) {
                    numMax = num;
                    sample[4] = i;
                }
                numSum += num;
                if (min > i) {
                    min = i;
                }
                if (max < i) {
                    max = i;
                }
                mean += (long) i * num;
                if (sum <= total / 2 && (sum + count[i]) > total / 2) {

                    if (total % 2 == 0) {
                        mid = sum == total / 2 ? (pre + i) / 2.0 : i;
                    } else {
                        mid = i;
                    }
                }
                pre = i;
                sum += count[i];
            }
        }
        sample[0] = min;
        sample[1] = max;
        sample[2] = mean / numSum;
        sample[3] = mid;
        return sample;
    }


//    public double[] sampleStats(int[] count) {
//        double[] sample = new double[5];
//        int countLength = count.length;
//        double min = Integer.MAX_VALUE;
//        double max = Integer.MIN_VALUE;
//        double mean = 0;
//        double median = 0;
//        double mode = 0;
//        int numMax = 0;
//        int numSum = 0;
//        int left = 0;
//        int right = count.length-1;
//        List<Integer> list = new ArrayList<>();
//        while (left <= right) {
//            while (count[left] == 0) {
//                left++;
//            }
//            while (count[right] == 0) {
//                right--;
//            }
//            if(count[left]>0){
//                if(min>left){
//                    min = left;
//                }
//                list.add(left);
//            }
//            if (count[right] > 0) {
//                if (max < right) {
//                    max = right;
//                }
//                list.add(right);
//            }
//
//        }
//
//
//        sample[0] = min;
//        sample[1] = max;
//        sample[2] = mean/numSum;
//        sample[3] =
//    }


    public static double[] sampleStats2(int[] count) {
        int n = count.length;
        int total = Arrays.stream(count).sum();
        double mean = 0.0;
        double median = 0.0;
        int minnum = 256;
        int maxnum = 0;
        int mode = 0;

        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        int cnt = 0;
        int maxfreq = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) count[i] * i;
            if (count[i] > maxfreq) {
                maxfreq = count[i];
                mode = i;
            }
            if (count[i] > 0) {
                if (minnum == 256) {
                    minnum = i;
                }
                maxnum = i;
            }
            if (cnt < right && cnt + count[i] >= right) {
                median += i;
            }
            if (cnt < left && cnt + count[i] >= left) {
                median += i;
            }
            cnt += count[i];
        }
        mean = (double) sum / total;
        median = median / 2.0;
        return new double[]{minnum, maxnum, mean, median, mode};
    }


    public double[] sampleStats3(int[] count) {
        double mininum = -1, maxinum = 0, mean = 0, median = 0, mode = 0;
        int count_last = 0, count_sum = 0;
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (mininum == -1 && count[i] != 0) mininum = i;
            if (count[i] > 0 && i > maxinum) maxinum = i;
            if (count[i] > count_last) {
                count_last = count[i];
                mode = i;
            }
            sum += (long) i * count[i];
            count_sum += count[i];
        }
        mean = (double) sum / count_sum;
        int mid = (count_sum - 1) / 2 + 1;
        int count_cur = 0;
        for (int i = 0; i < count.length; i++) {
            if (count_cur <= mid && count_cur + count[i] >= mid) {
                if (count_sum % 2 == 1) {
                    median = i;
                } else {
                    if (count_cur + count[i] >= mid + 1) {
                        median = i;
                    } else {
                        for (int j = i + 1; j < count.length; j++) {
                            if (count[j] > 0) {
                                median = i + j;
                                break;
                            }
                        }
                        median /= 2.0;
                    }
                }
                break;
            }
            count_cur += count[i];
        }
        return new double[]{mininum, maxinum, mean, median, mode};
    }
}
