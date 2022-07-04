package LeetCode.Sept_LeetCode;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Sept_LeetCode|LargestTimeforGivenDigits| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class LargestTimeforGivenDigits {
    String ans = "";

    public String largestTimeFromDigits(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (x >= 3) count++;
        }
        if (count == 4) return ans;
        backtrack(arr, "", new boolean[arr.length]);
        return ans.isEmpty() ? "" : ans.substring(0, 2) + ":" + ans.substring(2);

    }

    private void backtrack(int[] arr, String str, boolean vistited[]) {
        if (str.length() == 2) {
            if (Integer.parseInt(str) >= 24) return;
        }

        if (str.length() == 4) {
            if (Integer.parseInt(str.substring(2)) >= 60) return;
        }
        if (str.length() == 4) {
            if (ans.isEmpty()) {
                ans = str;
            } else {
                if (ans.compareTo(str) < 0) {
                    ans = str;
                }
            }
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            if (!vistited[i]) {
                str += arr[i];
                vistited[i] = true;
                backtrack(arr, str, vistited);
                vistited[i] = false;
                str = str.substring(0, str.length() - 1);
            }
        }

    }
}
