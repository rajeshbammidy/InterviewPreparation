package TopicWiseSolutions.Math;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    //Approach: It  is similar to finding the cycle in the linked List since it is clearly mentioned that we might end up looping 1 or some other number
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        while (true) {

            slow = findNext(slow);
            fast = findNext(fast);
            fast = findNext(fast);

            if (slow == fast) {
                break;
            }
        }
        return slow == 1;


    }

    private int findNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10 * n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
