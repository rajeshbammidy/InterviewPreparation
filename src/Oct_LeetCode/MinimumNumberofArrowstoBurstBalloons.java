package Oct_LeetCode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Oct_LeetCode|MinimumNumberofArrowstoBurstBalloons| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class MinimumNumberofArrowstoBurstBalloons {
    static class node {
        long x;
        long y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        ArrayList<node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new node(points[i][0], points[i][1]));
        }
        list.sort(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if (o1.y < o2.y) return -1;
                else if (o1.y > o2.y) return 1;
                else return 0;
            }
        });

        int ans = 0;
        long x = list.get(0).x;
        long y = list.get(0).y;
        for (int i = 1; i < list.size(); i++) {
            long curx = list.get(i).x;
            long cury = list.get(i).y;

            if (curx <= y) {
                x = Math.min(x, curx);
                y = Math.min(y, cury);

            } else {
                ans++;
                x = curx;
                y = cury;
            }
            if (i == list.size() - 1) {
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }
}
