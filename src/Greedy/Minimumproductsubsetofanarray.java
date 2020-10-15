package Greedy;

import java.util.HashSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Greedy|Minimumproductsubsetofanarray| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class Minimumproductsubsetofanarray {
    static int minProductSubset(int arr[], int n) {
        if (n == 01) return arr[0];
        int excNeg = Integer.MIN_VALUE;
        int negC = 0;
        int posC = 0;
        int smallPos = Integer.MAX_VALUE;
        boolean isZeroPresent = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                negC++;
                excNeg = Integer.max(excNeg, arr[i]);
            } else {
                if (arr[i] == 0) isZeroPresent = true;
                if (arr[i] != 0) smallPos = Math.min(smallPos, arr[i]);
                posC++;
            }
        }

        if (negC > 0 && (negC & 1) == 0) {
            int ans = 1;
            for (int i = 0; i < n; i++) {
                if (arr[i] != excNeg && arr[i] != 0) ans *= arr[i];
            }
            return ans;

        } else if (negC == 0 && isZeroPresent) return 0;
        else if (negC == 0 && !isZeroPresent) return smallPos;
        else if (negC > 0 && (negC & 1) > 0) {
            int ans = 1;
            for (int i = 0; i < n; i++) {

                ans *= arr[i];
            }
            return ans;
        }
        return -1;
    }
}
