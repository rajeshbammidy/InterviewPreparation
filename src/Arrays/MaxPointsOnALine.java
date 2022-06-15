package Arrays;

import java.util.HashMap;

/**
 * Project: InterviewPreparation
 * Package: Arrays / MaxPointsOnALine
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/
public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        int len = points.length;
        int max = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < len - max; i++) {
            double slope;
            int max_i = Integer.MIN_VALUE;
            for (int j = i + 1; j < len; j++) {
                if (points[j][0] - points[i][0] == 0) {
                    slope = (1e4 + 1);
                } else {
                    slope = Math.abs((double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]));
                    if (Math.abs(slope) == 0.0) slope = 0.0;
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max_i = Math.max(max_i, map.get(slope));
            }
            map.clear();
            max = Math.max(max, max_i);
        }
        return max + 1;

    }

    public static void main(String[] args) {
        System.out.println(new MaxPointsOnALine().maxPoints(new int[][]{{2, 3}, {3, 3}, {-5, 3}}));
    }
}
