package TopicWiseSolutions.Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Math_II|ToAndFro| on Dec,2019
 * Happy Coding :)
 *
 * To and Fro
 * The Guardians of the Galaxy have just landed on Earth. There are N cities in a row numbered from 1 to N. The cost of going from a city with number i to a city with number j is the remainder when (i+j) is divided by (n+1). The Guardians want to visit every city but in the minimum cost. What is the minimum cost that will be incurred? Constraints:
 * 1.   1 <= N <= 10000000
 * Input:
 * A single integer N denoting the number of cities.
 * Output:
 * Minimum cost to be able to travel to each city
 * Example: Input:
 * 3
 * Output:
 * 1
 */
public class ToAndFro {
    public int solve(int num) {
        return (num-1)/2;
    }
}
