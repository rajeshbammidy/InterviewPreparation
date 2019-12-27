package Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_II|CountPairsInArrayWhoseSumIsDivisibleByTheGivenNumber| on Dec,2019
 * Happy Coding :)
 * Count pairs in array whose sum is divisible by the given number
 * Given an array of integers A and an integer B, find and return the number of pairs in A whoes sum is divisible by B. Since the answer may be large, return the answer modulo (10^9 + 7).
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 * Return the total number of pairs for which the sum is divisible by B modulo (10^9 + 7).
 * Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^6
 * For Example
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 *     B = 2
 * Output 1:
 *     4
 *
 * Input 2:
 *     A = [5, 17, 100, 11]
 *     B = 28
 * Output 2:
 *     1
 */
public class CountPairsInArrayWhoseSumIsDivisibleByTheGivenNumber {
    public int solve(int[] arr, int k) {
        int mod=1000000000+7;
        long freq[] = new long[k];
        for (int i = 0; i < arr.length; i++) {
            ++freq[arr[i] % k];
        }
        long res = ((freq[0] * (freq[0] - 1)) / 2)%mod;
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {
            res += (freq[i] * freq[k - i])%mod;
        }
        if(k%2==0){
            res+=((freq[k/2]*(freq[k/2]-1)/2)%mod);
        }
        return (int)((res%mod+mod)%mod);
    }
}
