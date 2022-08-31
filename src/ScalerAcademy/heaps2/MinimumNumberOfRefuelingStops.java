package ScalerAcademy.heaps2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.heaps2
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 *
 * A car with infinite gas tank capacity initially at position 0 with B liters of gas. It uses 1 liter of gas per 1 mile that it drives. It starts moving to target position A which lies to the right of starting position.
 *
 * Along the way, there are gas stations. ith gas station is C[i] miles right of the starting position, and has D[i] liters of gas.
 *
 * What is the least number of refueling stops the car must make in order to reach its destination? If it cannot reach the destination, return -1.
 *
 * NOTE:
 *
 * If the car reaches a gas station with 0 fuel left, the car can still refuel there.
 * If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 *
 * Input Format
 *
 * First input argument is an integer A.
 * Second input argument is an integer B.
 * Third input argument is an array of integers C.
 * Fourth input argument is an array of integers D.
 * Output Format
 *
 * Return the least number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
 * Constraints
 *
 * 1 <= A, B, D[i] <= 10^9
 * 1 <= lenght of C = lenght of D < = 50000
 * C[0] < C[1] < C[2] < ... < C[C.length-1] < A
 * For Example
 *
 * Input 1:
 *     A = 100
 *     B = 10
 *     C = [10, 20, 30, 60]
 *     D = [60, 30, 30, 40]
 * Output 1:
 *     2
 *
 * Input 2:
 *     A = 100
 *     B = 2
 *     C = [10]
 *     D = [100]
 *
 * Output 2:
 *  -1
 *  Explanation: With initial fuel, we can't even reach the first station.
 */
public class MinimumNumberOfRefuelingStops {
    public int solve(int target, int tank, ArrayList<Integer> stations, ArrayList<Integer> fuels) {
        int prev = 0;
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stations.size(); i++) {
            tank -= stations.get(i) - prev;
            while (tank < 0 && !heap.isEmpty()) {
                tank += heap.poll();
                ans++;
            }
            if (tank < 0) return -1;
            prev = stations.get(i);
            heap.add(fuels.get(i));
        }
        tank -= target - prev;
        while (tank < 0 && !heap.isEmpty()) {
            tank += heap.poll();
            ans++;
        }
        if (tank < 0) return -1;
        return ans;
    }
}
