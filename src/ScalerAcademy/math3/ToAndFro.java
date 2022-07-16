package ScalerAcademy.math3;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_III / ToAndFro
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 *
 * The Guardians of the Galaxy have just landed on Earth.
 *
 * There are N cities in a row numbered from 1 to N.
 *
 * The cost of going from a city with number i to a city with number j is the remainder when (i+j) is divided by (n+1).
 *
 * The Guardians want to visit every city but in the minimum cost. What is the minimum cost that will be incurred?
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 10000000
 *
 *
 *
 * Input Format
 *
 * A single integer N denoting the number of cities.
 *
 *
 *
 * Output Format
 *
 * Minimum cost to be able to travel to each city
 *
 *
 *
 * Example Input
 *
 *  3
 *
 *
 * Example Output
 *
 *  1
 *
 *
 * Example Explanation
 *
 *  Tour would be 1 -> 3 -> 2.
 */

/**
 * Approach:
 * We go from 1 to N with 0 cost.
 * We go from N to 2 with 1 cost.
 * We go from 2 to N-1 with 0 cost.
 * And so on..
 * 0 cost is incurred N/2 times since i+j is equal to N+1, and for the remaining N/2 times, 1 cost is incurred.
 */
public class ToAndFro {
    public int solve(int A) {
        return (A-1)/2;
    }
}
