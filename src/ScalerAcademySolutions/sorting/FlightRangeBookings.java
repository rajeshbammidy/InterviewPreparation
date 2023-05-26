package ScalerAcademySolutions.sorting;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / FlightRangeBookings
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Problem Description
 * There is a company CorpFly which only takes booking from corporates. They have A flights and they are numbered from 1 to A.
 *
 * Corporate bookings are of the following form (i, j, K). This implies book K seats each on every flight numbered between i and j (inclusive).
 *
 * Given a 2-D array B of size M * 3 denoting a sequence of these bookings from corporates, your job is to tell the number of seats booked on each of the A flights.
 *
 * NOTE: Assume the number of seats in every flight is infinite.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 2 * 105
 *
 * 1 <= i <= j <= A
 *
 * 1 <= M <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is a 2-D array B of size M * 3.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the number of seats booked on each of the A flights.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 5
 * B = [ [1, 2, 10],
 * [2, 3, 20],
 * [2, 5, 25] ]
 *
 * Input 2:
 *
 * A = 5
 * B = [ [1, 2, 10],
 * [2, 3, 20],
 * [2, 5, 25] ]
 *
 *
 * Example Output
 * Output 1:
 *
 * [10, 55, 45, 25, 25]
 * Output 2:
 *
 * [10, 55, 45, 25, 25]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * First booking books 10 seats on flights 1 to 2(1 and 2). Final bookings in each flight after first booking: [10, 10, 0, 0, 0]
 * Second booking books 20 seats on flights 2 to 3(2 and 3). Final bookings in each flight after second booking: [10, 30, 20, 0, 0]
 * Third booking books 25 seats on flights 2 to 5(2,3,4,5). Final bookings in each flight after third booking: [10, 55, 45, 25, 25]
 * Explanation 2:
 *
 *
 * First booking books 10 seats on flights 1 to 2(1 and 2). Final bookings in each flight after first booking: [10, 10, 0, 0, 0]
 * Second booking books 20 seats on flights 2 to 3(2 and 3). Final bookings in each flight after second booking: [10, 30, 20, 0, 0]
 * Third booking books 25 seats on flights 2 to 5(2,3,4,5). Final bookings in each flight after third booking: [10, 55, 45, 25, 25]
 **/
public class FlightRangeBookings {

    public int[] solve(int flights, int[][] array) {
        int seats[] = new int[flights];
        for (int i = 0; i < array.length; i++) {
            seats[array[i][0] - 1] += array[i][2];
            if (array[i][1] < flights)
                seats[array[i][1]] += (-array[i][2]);
        }
        for (int i = 1; i < seats.length; i++) {
            seats[i] += seats[i - 1];
        }
        return seats;
    }

    public static void main(String[] args) {

    }
}
