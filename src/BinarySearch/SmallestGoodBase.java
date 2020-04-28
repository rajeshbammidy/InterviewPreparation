package BinarySearch;

import java.math.BigInteger;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|SmallestGoodBase| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class SmallestGoodBase {
    public String solve(String A) {
        long x = Long.parseLong(A);
        long nobits = (long) (Math.log(x) / Math.log(2)) + 1;
        BigInteger target = new BigInteger(A);
        for (long i = nobits; i >= 2; i--) {
            BigInteger low = new BigInteger("2");
            BigInteger high = new BigInteger((x - 1) + "");

            while (low.compareTo(high) == -1 || low.compareTo(high) == 0) {
                BigInteger k = low.add(high).divide(new BigInteger("2"));
                BigInteger num = k.pow((int) (i)).subtract(new BigInteger(1 + ""));
                BigInteger den = k.subtract(new BigInteger(1 + ""));
                BigInteger pow = num.divide(den);
                if (pow.compareTo(target) == 0)
                    return k.toString();
                else if (pow.compareTo(target) == -1) {
                    low = k.add(new BigInteger(1 + ""));
                } else {
                    high = k.subtract(new BigInteger(1 + ""));
                }
            }

        }
        return "";
    }
}
