package TopicWiseSolutions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Hashing|null.java| on Dec,2019
 * Happy Coding :)
 */
public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> list) {
        boolean visited[] = new boolean[list.size()];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            if (visited[i] == false) {
                temp.add(i + 1);
                for (int j = i + 1; j < list.size(); j++) {

                    if (!visited[j]) {
                        if (check(list.get(i), list.get(j))) {
                            visited[j] = true;
                            temp.add(j + 1);

                        }
                    }


                }

                res.add(temp);
            }
        }
        return res;
    }

    private boolean check(String a, String b) {
        String sa[] = a.split("");
        String sb[] = b.split("");
        Arrays.sort(sa);
        Arrays.sort(sb);

        return Arrays.equals(sa, sb);
    }
}
