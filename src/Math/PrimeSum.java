package Math;

import java.util.ArrayList;

public class PrimeSum {
    public static int[] primesum(int a) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean prime[] = new boolean[a];
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (prime[i] == false) {
                for (int j = i * i; j < a; j += i) {
                    if (prime[j] == false) prime[j] = true;
                }
            }
        }

        int x = 0;
        int y = 0;
        boolean ob = false;
        for (int i = 2; i < a; i++) {
            if (prime[i] == false) {
                list.add(i);
                if (i + i == a && !ob) {
                    x = i;
                    y = i;
                    ob = true;
                }
            }
        }

        int i = 0;
        int j = list.size() - 1;
        int p = 0;
        int q = 0;

        while (i < j) {
            if (list.get(i) + list.get(j) == a) {

                p = list.get(i);
                q = list.get(j);
                i++;
                j--;
            } else if (list.get(i) + list.get(j) > a) j--;
            else i++;
        }

        if (x != 0 && y != 0 && p != 0 && q != 0) {
            if (x < p || x == p && y < q) {
                return new int[]{x, y};
            } else {
                return new int[]{p, q};
            }
        }

        if (x == 0) {
            return new int[]{p, q};
        } else {
            return new int[]{x, y};
        }


    }
}
