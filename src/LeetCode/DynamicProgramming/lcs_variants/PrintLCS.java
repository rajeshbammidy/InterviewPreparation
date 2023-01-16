package LeetCode.DynamicProgramming.lcs_variants;

public class PrintLCS {
    private String dp[][];

    public void printLCS(String s1, String s2) {
        dp = new String[s1.length()][s2.length()];
        String lcs = findLcs(s1, s2, 0, 0);
        System.out.println(lcs);

    }

    private String findLcs(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) {
            return "";
        }
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = s1.charAt(i) + findLcs(s1, s2, i + 1, j + 1);
            return dp[i][j];
        }
        String left = findLcs(s1, s2, i + 1, j);
        String right = findLcs(s1, s2, i, j + 1);
        /**
         * You can tweak the below to get min/max costed lcs
         */
        if (left.length() > right.length()) {
            dp[i][j] = left;
        } else if (left.length() < right.length()) {
            dp[i][j] = right;
        } else {
            if (left.compareTo(right) > 0) {
                dp[i][j] = left;
                return left;
            }
            dp[i][j] = right;
            return right;
        }

        return dp[i][j];
    }
}
