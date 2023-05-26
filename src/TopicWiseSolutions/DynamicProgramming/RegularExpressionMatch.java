package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|RegularExpressionMatch| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class RegularExpressionMatch {
    public int isMatch(final String str, final String pattern) {
        char pat[] = new char[pattern.length()];
        int windex = 0;
        boolean firstTime = true;
        /**
         * Removing extra "*"
         */
        for (char ch : pattern.toCharArray()) {
            if (ch == '*' && firstTime) {
                pat[windex++] = ch;
                firstTime = false;
            } else if (ch != '*') {
                pat[windex++] = ch;
                firstTime = true;
            }
        }
        boolean dp[][] = new boolean[str.length() + 1][windex + 1];
        dp[0][0] = true;
        if (pat[0] == '*') {
            dp[0][1] = true;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str.charAt(i - 1) == pat[j - 1] || pat[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pat[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][windex] ? 1 : 0;
    }
}
