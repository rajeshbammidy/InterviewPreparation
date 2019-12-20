import oracle.sql.ARRAY;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    public int solve(ArrayList<Integer> list, ArrayList<Integer> counts) {
        int pat = 0;
        for (int x : counts) pat += x;

        int arr[] = new int[100000];

        for (int i = 0; i < counts.size(); i++) {
            arr[i + 1] = counts.get(i);
        }
        int copy[]=arr.clone();
        int left = 0;
        int c = 0;
        int ans = 0;
        int flag = -1;
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int right = 0; right < list.size(); right++) {

            if (--arr[list.get(right)] >= 0) c++;
            while (c == pat) {
                flag = 1;
                if (minlen > right - left + 1) {
                    minlen = right - left + 1;
                    start = left;
                    end = right;
                }
                if (++arr[list.get(left)] > 0) {
                    c--;
                }
                left++;

            }
        }
        if (flag == -1) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = start;
        int e = end;
        while (s <= e) {
            //System.out.print(list.get(s) + " ");
            int val = list.get(s++);

            map.put(val, map.getOrDefault(val, 0) + 1);
        }

       // System.out.println(map);
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {

            if (x.getKey() >= copy.length){
                ans += x.getValue();
            }
            else if (copy[x.getKey()] == 0){
                ans += x.getValue();
            }
            else if (copy[x.getKey()] < x.getValue()){
                ans += x.getValue() - copy[x.getKey()];
            }
        }
        return ans;

    }


    public static void main(String[] args) throws Exception {
ArrayList<Integer> l=new ArrayList<>(Arrays.asList(new Integer[]{1,1,5, 2, 3, 4,5, 1}));
ArrayList<Integer> c=new ArrayList<>(Arrays.asList(new Integer[]{2, 1, 1, 0}));
        System.out.println(new Test().solve(l,c));
    }


}