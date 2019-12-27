package Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_II|FindNthMagicNumber| on Dec,2019
 * Happy Coding :)
 *
 * Find nth Magic Number
 * Given an integer A, find and return the A'th magic number. A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 * Input Format
 * The only argument given is integer A.
 * Output Format
 * Return the A'th magic number.
 * Constraints
 * 1 <= A <= 5000
 * For Example
 * Input 1:
 *     A = 10
 * Output 1:
 *     650
 *
 * Input 2:
 *     A = 3
 * Output 2:
 *     30
 */
public class FindNthMagicNumber {
    public int solve(int num) {
        //Get the binary representation of the number
        String bin = Integer.toBinaryString(num);
        bin = new StringBuilder(bin).reverse().toString();
        int res = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                res += (Math.pow(5, i + 1) * 0);
            } else {
                res += (Math.pow(5, i + 1) * 1);
            }
        }
        return res;
    }
}
