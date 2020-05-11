package Backtracking;

import java.util.LinkedList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|KthPermutationSequence| on May,2020
 *  
 * Happy Coding :)
 **/
public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        int fact[] = new int[10];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = i * fact[i - 1];
        }
        k -= 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        String str = "";
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            str += list.get(index);
            list.remove(index);
            k = k - index * fact[i];
        }
        return str;

    }
}
