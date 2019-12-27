package Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_II|PalindromeInteger| on Dec,2019
 * Happy Coding :)
 *
 * Palindrome Integer
 * Determine whether an integer is a palindrome. Do this without extra space. A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic. Example :
 * Input : 12121
 * Output : True
 *
 * Input : 123
 * Output : False
 */
public class PalindromeInteger {
    public int isPalindrome(int num) {
        String str=num+"";
        if(new StringBuilder(str).reverse().toString().equals(str))return 1;
        return 0;
    }
}
