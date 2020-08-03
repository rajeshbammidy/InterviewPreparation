package Aug_LeetCode;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Aug_LeetCode|DesignHashSet| on Aug,2020
 *  
 * Happy Coding :)
 **/

import java.util.*;

public class DesignHashSet {
    /**
     * Initialize your data structure here.
     */
    int arr[];

    public void MyHashSet() {
        arr = new int[1000000 + 1];
        Arrays.fill(arr, -1);
    }

    public void add(int key) {
        arr[key] = key;

    }

    public void remove(int key) {
        arr[key] = -1;

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (arr[key] == -1) return false;
        return true;

    }
}
