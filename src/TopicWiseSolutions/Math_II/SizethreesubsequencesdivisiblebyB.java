package TopicWiseSolutions.Math_II;

import java.util.ArrayList;

public class SizethreesubsequencesdivisiblebyB {
    public int solve(ArrayList<Integer> list, int k) {
        long modValues[] = new long[k];
        for (int x : list) {
            modValues[x % k]++;
        }
        int mod = (int) (1e9 + 7);
        long ans = 0;
        for (int i = 0; i < modValues.length; i++) {
            for (int j = i; j < modValues.length; j++) {
                int rem = (k - (i + j) % k)%k;
                if (rem < j) continue;
                if (i == j && rem == j) {
                    ans = ans + (modValues[i] * (modValues[i] - 1) * (modValues[i] - 2)) / 6;
                    ans = ans % mod;
                } else if (i == j) {
                    ans = ans + ((modValues[i] * (modValues[i] - 1)) * modValues[rem]) / 2;
                    ans = ans % mod;
                } else if (i == rem) {
                    ans = ans + ((modValues[i] * (modValues[i] - 1)) * modValues[j]) / 2;
                    ans = ans % mod;
                } else if (j == rem) {
                    ans = ans + ((modValues[j] * (modValues[j] - 1)) * modValues[i]) / 2;
                    ans = ans % mod;
                } else {
                    ans = ans + (modValues[i] * modValues[j] * modValues[rem]);
                    ans = ans % mod;
                }
            }

        }
        return (int) ans;
    }

}
