package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|FizzBuzz| on Dec,2019
 * Happy Coding :)
 *
 * FizzBuzz
 *  Fizzbuzz is one of the most basic problems in the coding interview world. Try to write a small and elegant code for this problem.
 * Given a positive integer A, return an array of strings with all the integers from 1 to N. But for multiples of 3 the array should have “Fizz” instead of the number. For the multiples of 5, the array should have “Buzz” instead of the number. For numbers which are multiple of 3 and 5 both, the array should have "FizzBuzz" instead of the number. Look at the example for more details. Example
 * A = 5
 * Return: [1 2 Fizz 4 Buzz]
 */
public class FizzBuzz {
    public String[] fizzBuzz(int n) {
        String str[] = new String[n];
        int i = 0;
        for (int j = 1; j <= n; j++) {
            String t = "";
            int f = 1;
            if (j % 3 == 0) {
                f = 0;
                t += "Fizz";
            }
            if (j % 5 == 0) {
                f = 0;
                t += "Buzz";

            }
            if (f == 1) {
                t += j;
                str[i++] = t;
            } else {
                str[i++] = t;
            }


        }
        return str;
    }
}
