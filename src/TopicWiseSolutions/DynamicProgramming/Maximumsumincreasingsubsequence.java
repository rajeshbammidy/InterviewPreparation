package TopicWiseSolutions.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Maximumsumincreasingsubsequence {
    static int maxSum(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
        }
        if(dp.length==1)return dp[0];
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[j]+arr[i],dp[i]);
                    max=Math.max(max,dp[i]);
                }else{
                    max=Math.max(max,dp[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            bf.readLine();



            String iws[] = bf.readLine().split("\\s");
            int wt[] = new int[iws.length];

            for (int j = 0; j < wt.length; j++) {
                wt[j] = Integer.parseInt(iws[j]);
            }

            System.out.println(maxSum(wt));
        }

    }
}
