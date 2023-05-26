package TopicWiseSolutions.BinarySearch;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.BinarySearch|Maximumheightofthestaircase| on Apr,2020
 *  
 * Happy Coding :)
 *
 * Maximum height of the staircase
 * Problem Description
 * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks. The first stair would require only one block, the second stair would require two blocks and so on. Find and return the maximum height of the staircase.
 *
 *
 * Problem Constraints
 * 0 <= A <= 109
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 * Output Format
 * Return the maximum height of the staircase using these blocks.
 *
 *
 * Example Input
 * Input 1:
 *  A = 10
 * Input 2:
 *  20
 *
 *
 * Example Output
 * Output 1:
 *  4
 * Output 2:
 *  5
 *
 *
 * Example Explanation
 **/
public class Maximumheightofthestaircase {


    public static int solve(int d) {
        long ans = 0;
        long beg = 1;
        long end = d;
        long sum = d;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            long sqr = mid * (mid + 1) / 2;
            if (sqr == sum) {
                ans = mid;
                break;
            }
            if (sqr < sum) {
                ans = mid;
                beg = mid + 1;
            } else end = mid - 1;

        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(496));
    }
}
