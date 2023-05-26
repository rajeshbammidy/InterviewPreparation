package ScalerAcademySolutions.backtracking;

import java.util.ArrayList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / KthPermutationSequence
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Question:
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3 ) :
 *
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 * Given n and k, return the kth permutation sequence.
 *
 * For example, given n = 3, k = 4, ans = "231"
 *
 * Good questions to ask the interviewer :
 *
 * What if n is greater than 10. How should multiple digit numbers be represented in string?
 * In this case, just concatenate the number to the answer. so if n = 11, k = 1, ans = "1234567891011"
 *
 * Whats the maximum value of n and k?
 * In this case, k will be a positive integer thats less than INT_MAX. n is reasonable enough to make sure the answer does not bloat up a lot.
 *
 * Approach from Observations:
 * 1. Permutations are divided into blocks of size x starting with the same element, where x= k/ (n-1) !, you can get the digit from digit array using x
 * 2. Once the respective digit is obtained find the next starting digit, k = k% (n-1)! which will tell you the next sequence you have to find in the blocks of size x= k/ (n-1) !
 **/
public class KthPermutationSequence {

    public String getPermutation(int n, int k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        while (true) {
            int digitIndex = k / fact;
            int number = numbers.get(digitIndex);
            ans += number;
            numbers.remove(digitIndex);
            if (numbers.size() == 0) break;
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

}
