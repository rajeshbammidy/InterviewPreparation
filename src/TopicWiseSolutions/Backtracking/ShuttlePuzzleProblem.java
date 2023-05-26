package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|ShuttlePuzzleProblem| on May,2020
 *  
 * Happy Coding :)
 **/
public class ShuttlePuzzleProblem {
    public ArrayList<String> solve(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "W";
        }
        str += "H";
        for (int i = 0; i < n; i++) {
            str = str + "B";
        }

        String rev = new StringBuilder(str).reverse().toString();
        ArrayList<String> res = new ArrayList<>();
        res.add(str);
        backtrack(str, rev, res);
        //System.out.println(res);
        return res;
    }

    private boolean backtrack(String str, String rev, ArrayList<String> res) {

        if (str.equals(rev)) {
            return true;
        }

        if (str.contains("WH")) {
            str = str.replaceAll("WH", "HW");
            res.add(str);
            boolean ret = backtrack(str, rev, res);
            if (!ret) {
                str = str.replaceAll("HW", "WH");
                res.remove(res.size() - 1);
            } else return true;

        }
        if (str.contains("HB")) {
            str = str.replaceAll("HB", "BH");
            res.add(str);
            boolean ret = backtrack(str, rev, res);
            if (!ret) {
                str = str.replaceAll("BH", "HB");
                res.remove(res.size() - 1);
            } else return true;

        }


        if (str.contains("HWB")) {
            str = str.replaceAll("HWB", "BWH");
            res.add(str);
            boolean ret = backtrack(str, rev, res);
            if (!ret) {
                str = str.replaceAll("BWH", "HWB");
                res.remove(res.size() - 1);
            } else return true;

        }

        if (str.contains("WBH")) {
            str = str.replaceAll("WBH", "HBW");
            res.add(str);
            boolean ret = backtrack(str, rev, res);
            if (!ret) {
                str = str.replaceAll("HBW", "WBH");
                res.remove(res.size() - 1);
            } else return true;

        }
        return false;
    }
}
