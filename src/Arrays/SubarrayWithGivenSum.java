package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//It takes O(n)
public class SubarrayWithGivenSum {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input[] = bf.readLine().split("\\s");
        String sarray[] = bf.readLine().split(",");
        int n = Integer.parseInt(input[0]);
        int sum = Integer.parseInt(input[1]);
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sarray[i]);
        }

        int curr_sum = 0;
        int start = 0;
        int end;
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            if (curr_sum == sum) {
                System.out.println(start + " " + i);
                break;
            }
            if (curr_sum > sum && start < i) {
                while (curr_sum > sum) {
                    curr_sum -= arr[start++];
                }
            }

        }

    }


}
