

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Main {
    Integer dp[][];
    static int MAX_VALUE = (int) 1e4;

    public int minCut(String s) {
        dp = new Integer[s.length()][s.length()];
        return minCount(s, 0, s.length() - 1);

    }

    private int minCount(String s, int i, int j) {
        if (i > j) return 0;
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        int min = MAX_VALUE;
        /**
         * Recursively call only when the left substring is a palindrome.
         * You might be thinking "If the left substring is not palindrome we can partition it further to get the min partitions at i"
         * But those partitions can be taken care by the right recursive call we make,so we dont have make the left recursive call
         * again and again
         *
         */
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                min = Math.min(1 + minCount(s, k + 1, j), min);
            }

        }
        dp[i][j] = min;
        return min;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Main().minCut("abc"));
    }


}

