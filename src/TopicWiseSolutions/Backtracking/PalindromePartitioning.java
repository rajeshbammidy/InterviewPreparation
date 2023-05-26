package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|PalindromePartitioning| on May,2020
 *  
 * Happy Coding :)
 **/
public class PalindromePartitioning {
    public List<List<String>> partition(String str) {
        List<List<String>> res = new ArrayList<>();
        backtrack(str, 0, new ArrayList<String>(), res);
        return res;
    }

    private void backtrack(String str, int start, ArrayList<String> aux, List<List<String>> res) {
        if (start == str.length()) res.add(new ArrayList<>(aux));

        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str.substring(start, i + 1))) {
                aux.add(str.substring(start, i + 1));
                backtrack(str, i + 1, aux, res);
                aux.remove(aux.size() - 1);
            }
        }


    }

    private boolean isPalindrome(String substring) {
        return new StringBuilder(substring).reverse().toString().equals(substring);
    }
}
