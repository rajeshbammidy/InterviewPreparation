package TopicWiseSolutions.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumOperations {
    public static int minOp(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                min = dp[i / 2]+1;
            }
            min = Math.min(min, dp[i - 1]+1);
            dp[i]=min;
        }


        return dp[n];
    }

    public static void main(String[] args) throws  Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine());
        while (t-->0){
            int n=Integer.parseInt(bf.readLine());
            System.out.println(minOp(n));
        }

    }

}
