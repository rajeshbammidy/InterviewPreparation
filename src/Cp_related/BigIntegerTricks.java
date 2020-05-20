package Cp_related;

import java.math.BigInteger;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Cp_related|BigIntegerTricks| on May,2020
 *  
 * Happy Coding :)
 **/
public class BigIntegerTricks {
    public static void main(String[] args) {
        int a = 12;
        int b = 23;
        /**
         * Primitive to BigInteger conversion
         */
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);

        String p = "125455";
        String q = "987456";

        /**
         * String to to BigInteger conversion
         */
        BigInteger bp = new BigInteger(p);
        BigInteger bq = new BigInteger(q);

        /**
         * BigInteger to primitive Conversion,if the bigint is beyond int limit you will get some grabage value
         *
         */

        int r1 = ba.intValue();
        /**
         * BigInteger to String
         */
        String str = ba.toString();


        /**
         * To check if it is a prime
         */
        boolean isPrime = BigInteger.valueOf(3).isProbablePrime(1);

        /**
         * find gcd;
         */

        int gcd = BigInteger.valueOf(5).gcd(BigInteger.valueOf(6)).intValue();

    }
}
