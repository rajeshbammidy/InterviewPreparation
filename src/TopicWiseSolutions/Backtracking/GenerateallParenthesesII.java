package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|GenerateallParenthesesII| on May,2020
 *  
 * Happy Coding :)
 **/
public class GenerateallParenthesesII {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, res, n);
        System.out.println(res);
        return res;

    }

    private void backtrack(String str, int l, int r, List<String> res, int n) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }


        if (l < n) {
            backtrack(str + "(", l + 1, r, res, n);
        }
        /**
         * We have to add right parenthesis only when the left exists
         */
        if (l > r && r < n) {
            backtrack(str + ")", l, r + 1, res, n);
        }
    }
}
