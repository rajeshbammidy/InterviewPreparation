package Arrays_GFG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays_GFG|MissingNumberInArray.java| on Jul,2019
 * Happy Coding :)
 */
public class MissingNumberInArray {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str[] = bf.readLine().split(" ");
        int arr[] = new int[n];
        int x = 0;
        int sum = 0;
        for (String s : str) {
            arr[x++] = Integer.parseInt(s.trim());
            sum += arr[x - 1];
        }

        int orgSum = (n * (n + 1)) / 2;
        System.out.println(orgSum-sum);

    }
}
