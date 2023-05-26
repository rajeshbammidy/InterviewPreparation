package TopicWiseSolutions.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|Triplets.java| on Jul,2019
 * Happy Coding :)
 */
public class Triplets {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str[] = bf.readLine().split(",");
        int arr[] = new int[n];
        int x = 0;
        for (String s : str) {
            arr[x++] = Integer.parseInt(s.trim());
        }
        Arrays.sort(arr);
        int k = n - 1;//last index
        int i, j;
        int count = 0;
        while (k > 1) {
            i = 0;
            j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    count++;
                    System.out.println(arr[i] + " " + "+ " + arr[j] + " =" + arr[k]);
                    break;
                } else if (arr[i] + arr[j] < arr[k]) {
                    i++;
                } else if (arr[i] + arr[j] > arr[k]) {
                    j--;
                }
            }
            k--;
        }

        System.out.println("Count is " + count);


    }
}
