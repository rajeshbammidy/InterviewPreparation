package Hashing;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 *
 * Largest Continuous Sequence Zero Sum
 * Find the largest continuous sequence in a array which sums to zero. Example:
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 *  NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class Lszero {
    public ArrayList<Integer> lszero(ArrayList<Integer> list) {
        int start = 0;
        int end = 0;
        long psum = 0;
        int maxSize = 0;
        int flag = 0;
        LinkedHashMap<Long, Integer> map = new LinkedHashMap<>();
        Long l=new Long(0);
        map.put(l,-1);
        for (int i = 0; i < list.size(); i++) {
            psum += list.get(i);

            if (map.containsKey(psum)) {
                flag = 1;
                if ((i - (map.get(psum) + 1) + 1) > maxSize) {
                    start = map.get(psum) + 1;
                    end = i;
                    maxSize = end - start + 1;
                }


            } else {
                map.put(psum, i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (flag == 1) {

            for (int i = start; i <= end; i++) res.add(list.get(i));
            return res;
        } else {
            if (map.containsKey(0)) res.add(0);
            return res;
        }


    }

    public static void main(String[] args) {


    }
}
