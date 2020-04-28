package BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|AthMagicalNumber| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class AthMagicalNumber
{
    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public int solve(int a, int b, int c) {
        long mod = (long) (1e18);
        long min = 0;
        long max = (long) (1e18);
        long ans=0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long l = (((b % mod) * (c % mod)) % mod) / gcd(b, c);
            long fx = ((mid / b) % mod + (mid / c) % mod) % mod - (mid / l);



            if (fx < a) min = (mid + 1)%mod;
            else{
                ans=mid;
                max = mid-1 ;
            } //greater than or equal to
        }
        return (int) (ans % (1e9 + 7));
    }
}
