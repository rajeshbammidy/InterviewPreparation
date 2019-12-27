package Math_I;

import java.util.TreeSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_I|DivisorGame| on Dec,2019
 * Happy Coding :)
 * Divisor game
 * Scooby has 3 three integers A, B and C. Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell number of special integers less than or equal to A. Constraints:
 * 1<=A,B,C<=1000000000
 * Input:
 * A positive integer A
 * A positive integer B
 * A positive integer C
 * Note:
 * Your code will run against multiple testcases
 * Output:
 * One integer corresponding to the number of special integers less than or equal to A.
 * Examples: Input:
 * 12
 * 3
 * 2
 * Output:
 * 2
 * Explanation:
 * The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
 */
public class DivisorGame {
    public int solve(int a, int b, int c) {
        int m=1;

        TreeSet<Integer> set=new TreeSet<>();
        while (b*m<=a){
            if((b*m)%c==0){
                set.add(b*m);
            }
            m++;
        }
        m=1;
        while (c*m<=a){
            if((c*m)%b==0){
                set.add(c*m);
            }
            m++;
        }
        return set.size();

    }
}
