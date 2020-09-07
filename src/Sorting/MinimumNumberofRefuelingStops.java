package Sorting;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|MinimumNumberofRefuelingStops| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class MinimumNumberofRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target)
            return 0;

        // Priority Queue
        // LOGIC: If we can reach another gas station, let's always grab the one that adds the most fuel
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> stations[b][1] - stations[a][1]);

        int trips = 0;

        // add all points that offer positive gas
        for (int i = 0; i < stations.length; i++)
            if (stations[i][1] > 0)
                pq.offer(i);

        while (!pq.isEmpty()) {
            ++trips;
            ArrayList<Integer> tmp = new ArrayList<>(); // hold a list of gas locations we couldn't hit on this round that provide more fuel

            // if we can't reach the next point, let's save it for a potential other future trip
            while (!pq.isEmpty() && startFuel < stations[pq.peek()][0])
                tmp.add(pq.poll());

            if (pq.isEmpty())
                return -1;

            startFuel += stations[pq.poll()][1];

            if (startFuel >= target)
                return trips;

            // add back gas stations we could have taken!
            for (int n : tmp)
                pq.offer(n);
        }

        return -1;
    }
}
