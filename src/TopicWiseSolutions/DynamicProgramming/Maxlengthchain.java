package TopicWiseSolutions.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Maxlengthchain {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    int maxChainLength(Pair arr[], int n) {
        ArrayList<Pair> list = new ArrayList<>();
        for(Pair p:arr)list.add(p);
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.y - o2.y;
            }
        });
        int i = 0;
        for (Pair p : list) arr[i++] = p;
        return lis(arr);
    }

    int lis(Pair arr[]) {
        int dp[] = new int[arr.length];

        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[j].y < arr[i].x && dp[i] <= dp[j]) dp[i] = 1 + dp[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int x : dp) max = Math.max(max, x);
        return max;
    }


    public static void main(String[] args) {
        Pair arr[] = new Pair[5];
        arr[0] = new Pair(5, 24);
        arr[1] = new Pair(39, 60);
        arr[2] = new Pair(15, 28);
        arr[3] = new Pair(27, 40);
        arr[4] = new Pair(50, 90);
        System.out.println(new Maxlengthchain().maxChainLength(arr, 5));
    }
}
