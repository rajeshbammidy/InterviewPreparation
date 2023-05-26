package TopicWiseSolutions.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and depth d(i) (all real numbers). You want to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base. It is also allowable to use multiple instances of the same type of box.
 * Source: http://people.csail.mit.edu/bdean/6.046/dp/. The link also has video for explanation of solution.
 *
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|BoxStackingProblem| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class BoxStackingProblem {
    static class Box {
        int h, w, d, area;


        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

    }

    static int maxStackHeight(Box arr[], int n) {
        Box inc[] = new Box[3 * n];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            Box box = arr[i];
            inc[j++] = new Box(box.h, Math.max(box.d, box.w), Math.max(box.d, box.w));
            inc[j++] = new Box(box.d, Math.max(box.h, box.w), Math.max(box.h, box.w));
            inc[j++] = new Box(box.w, Math.max(box.h, box.d), Math.max(box.h, box.d));
        }
        Arrays.sort(inc, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return -o1.area - o2.area;
            }
        });

        int dp[] = new int[inc.length];
        dp[0] = inc[0].h;
        for (int i = 1; i < inc.length; i++) {
            Box cur = inc[i];
            dp[i] = cur.h;
            for (int k = 0; k < i; k++) {

                Box prev = inc[k];

                if (cur.d > prev.d && cur.w > prev.w && dp[k] + cur.h > dp[k]) dp[i] = dp[k] + cur.h;
            }
        }
        int max = Integer.MIN_VALUE;

        for (int x : dp) max = Math.max(x, max);
        return max;
    }
}
