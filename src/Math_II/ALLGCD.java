package Math_II;

import java.util.TreeSet;

public class ALLGCD {
    public int solve(int[] arr) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<arr.length;i++){

            for(int j=i;j<arr.length;j++){
                int val=gcd(arr[i],arr[j]);
                set.add(val);
            }
        }
        return set.size();
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (a == 1) return 1;

        return gcd(b % a, a);

    }
}
