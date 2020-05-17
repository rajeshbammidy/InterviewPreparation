package Strings;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Strings|FindAllAnagramsinaString| on May,2020
 *  
 * Happy Coding :)
 **/
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String gs, String pt) {
        List<Integer> res = new ArrayList<>();
        if (gs.isEmpty()) return res;

        LinkedList<Character> orgList = new LinkedList<>();
        HashMap<Character, Integer> orgMap = new HashMap<>();
        for (char ch : pt.toCharArray()) {
            orgList.add(ch);
            orgMap.put(ch, orgMap.getOrDefault(ch, 0) + 1);
        }

        LinkedList<Character> curList = new LinkedList<>();
        HashMap<Character, Integer> curMap = new HashMap<>();
        for (int i = 0; i < gs.length(); i++) {
            char ch = gs.charAt(i);

            if (!orgMap.containsKey(ch)) {
                curList.clear();
                curMap.clear();
                continue;
            }

            if (orgMap.containsKey(ch) && curMap.containsKey(ch) && curMap.get(ch) + 1 > orgMap.get(ch)) {
                curList.add(ch);
                curMap.put(ch, curMap.getOrDefault(ch, 0) + 1);
                while (curMap.get(ch) > orgMap.get(ch)) {
                    char temp = curList.get(0);
                    curList.remove(0);
                    curMap.put(temp, curMap.get(temp) - 1);
                }

                continue;
            }

            if (curMap.get(ch) == null && orgMap.containsKey(ch)) {
                curMap.put(ch, 1);
                curList.add(ch);
            } else if (orgMap.containsKey(ch) && curMap.get(ch) < orgMap.get(ch)) {
                curMap.put(ch, curMap.getOrDefault(ch, 0) + 1);
                curList.add(ch);
            }

            if (curList.size() == orgList.size()) {
                int index = i - orgList.size() + 1;
                res.add(index);
                char temp = curList.get(0);
                curList.remove(0);
                if (curMap.get(temp) == 1) {
                    curMap.remove(temp);
                } else {
                    curMap.put(temp, curMap.get(temp) - 1);
                }

            }

        }

        System.out.println(res);
        return res;
    }
}
