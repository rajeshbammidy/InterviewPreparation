package Arrays_GFG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays_GFG|MaxSubarraySum.java| on Jul,2019
 * Happy Coding :)
 *
 * Kadane's Algorithm
 */
public class MaxSubarraySum {
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str[] = bf.readLine().split(",");
        int arr[] = new int[n];
        int x = 0;
        for (String s : str) {
            arr[x++] = Integer.parseInt(s.trim());
        }

        int max_sum=Integer.MIN_VALUE;
        int curr_sum=0;

        for(int i=0;i<n;i++){
            curr_sum+=arr[i];
            if(curr_sum>max_sum)max_sum=curr_sum;
            else if(curr_sum<0)curr_sum=0;

        }

        System.out.println(max_sum);
    }
}
