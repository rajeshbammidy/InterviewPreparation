package ScalerAcademy.math_II;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / SortedPermutationRank
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 *
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 *
 *
 * Input Format
 * First argument is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the rank of the given string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "acb"
 * Input 2:
 *
 * A = "a"
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Given A = "acb".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 * Explanation 2:
 *
 * Given A = "a".
 * Rank is clearly 1.
 */

/**
 * Problem Description
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 *
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 *
 *
 * Input Format
 * First argument is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the rank of the given string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "acb"
 * Input 2:
 *
 * A = "a"
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Given A = "acb".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 * Explanation 2:
 *
 * Given A = "a".
 * Rank is clearly 1.
 */

/**
 * Approach:calculate the rank by considering the elements less than the current element.
 */
public class SortedPermutationRank {
    static int mod = (int) (1e6 + 3);

    long factorial(int n) {
        long arr[] = new long[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = (i % mod * arr[i - 1] % mod) % mod;
        }
        return arr[n];
    }

    public int findRank(String str) {
        char arr[] = str.toCharArray();
        long rank = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int numberOfCharsLessThanCurChar = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) numberOfCharsLessThanCurChar++;
            }
            rank = (rank % mod + (numberOfCharsLessThanCurChar % mod * factorial(n - i - 1) % mod) % mod) % mod;
        }
        return (int) (rank + 1);
    }

}
