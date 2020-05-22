package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Strings|SortCharactersByFrequency| on May,2020
 *  
 * Happy Coding :)
 **/
public class SortCharactersByFrequency {
    static class node {
        String ch;
        int freq;

        public node(char ch, int index) {
            this.ch = ch + "";
            this.freq = index;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<node> list = new ArrayList<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                int ind = map.get(ch);
                list.get(ind).freq += 1;
                list.get(ind).ch = list.get(ind).ch + ch;

            } else {
                map.put(ch, i++);
                list.add(new node(ch, 1));
            }
        }

        Collections.sort(list, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return -(o1.freq - o2.freq);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (node x : list) sb.append(x.ch);
        return sb.toString();
    }
}
