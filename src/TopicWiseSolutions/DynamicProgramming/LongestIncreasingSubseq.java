package TopicWiseSolutions.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSubseq {

    int lis(int arr[]) {
        int dp[] = new int[arr.length];

        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && dp[i] <= dp[j]) dp[i] = 1 + dp[j];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int x:dp)max=Math.max(max,x);
        return max;
    }



    public static void main (String[] args)throws Exception {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine());
        while (t-->0){
            int n=Integer.parseInt(bf.readLine());;
            String inp[]=bf.readLine().split("\\s");
            int arr[]=new int[n];
            int i=0;
            for(String x:inp)arr[i++]=Integer.parseInt(x);
            System.out.println(new LongestIncreasingSubseq().lis(arr));
        }
        //code
    }
}
