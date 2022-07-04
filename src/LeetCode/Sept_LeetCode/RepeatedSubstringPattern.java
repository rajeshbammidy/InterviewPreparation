package LeetCode.Sept_LeetCode;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Sept_LeetCode|RepeatedSubstringPattern| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class RepeatedSubstringPattern {
    static int lcs(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        int m = dp.length;
        int n = dp[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }

            }
        }
        System.out.println(max);
        return max;


    }

    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==0)return true;
        int ans = lcs(s, s);
        int diff=s.length()-ans;
        return ans%diff==0;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("ababac"));
    }
}
