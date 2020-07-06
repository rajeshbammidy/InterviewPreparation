import java.util.*;

class InvalidInputException extends Exception {

}


public class Test {
    static boolean dp[][];

    static boolean isPosSubSetSum(int arr[], int sum) {
        dp = new boolean[arr.length + 1][sum + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 0; i < m; i++) dp[i][0] = true;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (arr[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }

            }
        }
        //   System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }


    public boolean splitArraySameAverage(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int x : arr) sum += x;
        boolean feasible = false;
        for (int i = 1; i <= arr.length; i++) {
            if ((i * sum) % n == 0) feasible = true;
        }
        if (!feasible) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 1; i <= arr.length / 2; i++) {
            map.put((i * sum) / n, i);
            max =(i * sum) / n;
        }
        if(max==-1)return false;


        int dp[][] = new int[arr.length + 1][max + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] == j || (j > arr[i - 1] && dp[i - 1][j - arr[i - 1]] > 0)) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + 1;
                    if (map.containsKey(j) && map.get(j) == dp[i][j]) return true;
                }


            }
        }

        return false;
    }


    public static void main(String[] str) {
        System.out.println(new Test().splitArraySameAverage(new int[]{6,8,18,3,1}));

    }

}