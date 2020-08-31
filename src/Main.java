import java.util.ArrayList;
import java.util.*;


public class Main {

    /**
     * DP solution
     */
    public static void findMinPath(int n, int values[]) {
        /**
         * If the target value is 1
         */
        if (n == 1) {
            System.out.println(1);
            return;
        }
        /**
         * If the given values lenght is 0
         */
        if (values.length == 0) {
            System.out.println(-1);
            return;
        }

/**
 * Sort the values
 */
        Arrays.sort(values);
        if (n == 0 && values[0] == 0) {
            System.out.println(1 + " " + 0);
            return;
        }
        LinkedHashSet<Integer> set = removeNumbers(values);
        values = new int[set.size()];
        int k = 0;
        for (int x : set) values[k++] = x;

        String dp[][] = new String[values.length + 1][n + 1];
        Arrays.fill(dp[0], -1 + "");
        dp[0][1] = 1 + "";

        for (int i = 1; i < dp.length; i++) {

            int v = values[i - 1];
            for (int j = 1; j < dp[0].length; j++) {

                if (v > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (j % v == 0) {
                    int q = j / v;

                    String cur = dp[i][q] + "-" + v;
                    if (dp[i][q].equals("-1")) {
                        cur = -1 + "";
                    }
                    if (dp[i - 1][j].equals("-1")) {
                        dp[i][j] = cur;
                        continue;
                    } else {
                        if (cur.length() < dp[i - 1][j].length()) {
                            dp[i][j] = cur;
                            continue;
                        } else if (cur.compareTo(dp[i - 1][j]) < 0) {
                            dp[i][j] = cur;
                            continue;
                        }
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }



        }
        String ans = "-1";
        for (int i = 1; i < dp.length; i++) {

            if (dp[i][dp[i].length - 1].equals("-1")) continue;


            if (ans.equals("-1") || ans.length() > dp[i][dp[i].length - 1].length()) {
                ans = dp[i][dp[i].length - 1];
            } else if (ans.compareTo(dp[i][dp[i].length - 1]) > 0) {
                ans = dp[i][dp[i].length - 1];
            }


        }

        if (ans.equals("-1")) {
            System.out.println(-1);
            return;
        }
        String result[] = ans.split("-");
        for (int i = 0; i < result.length; i++) {
            if (i == 0) System.out.print(result[i]);
            else System.out.print(" " + result[i]);
        }


    }

    private static LinkedHashSet<Integer> removeNumbers(int[] values) {
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        for (int x : values) {
            if (x != 0 && x != 1) res.add(x);
        }
        return res;
    }


    public static void main(String[] args) {
        /**
         * Example call
         * findMinPath(15, new int[]{3, 5, 6, 8, 1});
         */
        findMinPath(16, new int[]{3, 5, 6, 8, 1});

    }
}
