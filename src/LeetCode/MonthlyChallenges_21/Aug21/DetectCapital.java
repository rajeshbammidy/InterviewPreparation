package LeetCode.MonthlyChallenges_21.Aug21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Aug_LeetCode|DetectCapital| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class DetectCapital {
    public boolean detectCapitalUse(String word) {

        if (word.length() == 0) return false;

        int firstChar = (int) word.charAt(0);

        if (firstChar >= 65 && firstChar <= 90) {
            boolean allSmall = false, allCap = false;

            for (int i = 1; i < word.length(); i++) {
                int ch = (int) word.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    if (allSmall) return false;
                    allCap = true;
                } else {
                    if (allCap) return false;
                    allSmall = true;
                }

            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                int ch = (int) word.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    return false;
                }

            }

        }

        return true;

    }
}
