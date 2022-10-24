package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class spiderman {
    /**
     * dpPath: to memoize the variants, in my case Im memoizing the index and the sum at that index, with values as the optimal path
     */
    static HashMap<String, String> dpPath;

    public static void main(String[] args) throws Exception {
        /**
         * Read the input
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bf.readLine());
        while (testCases-- > 0) {

            /**
             * initialize the dpPath
             */
            dpPath = new HashMap<>();
            int n = Integer.parseInt(bf.readLine());
            int sum = 0;
            Integer distances[] = Arrays.stream(bf.readLine().split("\\s")).map(x -> Integer.parseInt(x)).toArray(Integer[]::new);

            for (int x : distances) sum += x;
            /**
             * If the sum of the distances is odd, it will never help the spider man to land on the street level.
             * So return impossible if the sum is odd
             */
            if ((sum & 1) != 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            /**
             * findOptimalPathDP: takes the distance,index and the current height as the input
             */
            String optimalPath = findOptimalPathDP(distances, 1, distances[0]);
            /**
             * If the path contains the string `IMPOSSIBLE`, which means there is no way that spider man can reach to the same position as that
             * of initial position
             */
            if (optimalPath.contains("IMPOSSIBLE")) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("U" + optimalPath);
            }
        }


    }


    /**
     * @param distances  : input distance
     * @param index:     index of the array distance
     * @param curHeight: current height at index i
     * @return optimal path if exists any
     */
    static String findOptimalPathDP(Integer distances[], int index, int curHeight) {

        /**
         * if the current index is the last element of the distances array, since the number of elements in the distances array is easy and we
         * also know that fact that we have taken UP as the initial step, we should definitely take DOWN in our last step to reach the street level
         *
         */
        if (index == distances.length - 1 && curHeight - distances[index] == 0) {
            dpPath.put(index + ":" + curHeight, "D");
            return dpPath.get(index + ":" + curHeight);
        }

        /**
         * curHeight can never be -ve, hence returning `IMPOSSIBLE`
         */
        if (curHeight < 0 || index == distances.length) {
            return "IMPOSSIBLE";
        }

        /**
         * If the path exists in the dpPath,simply return it
         */
        if (dpPath.get(index + ":" + curHeight) != null) {
            return dpPath.get(index + ":" + curHeight);
        }

        /**
         * Make a recursive call by taking UP
         */
        String pathWithUpDirection = "U" + findOptimalPathDP(distances, index + 1, curHeight + distances[index]);
        /**
         * Make a recursive call by taking DOWN
         */
        String pathWithDownDirection = "D" + findOptimalPathDP(distances, index + 1, curHeight - distances[index]);

        int minHeightPossibleWithUp = -1;
        int minHeightPossibleWithDown = -1;

        /**
         * If both of the above made choices didnt lead to optimal path, return IMPOSSIBLE and store it
         */
        if (pathWithUpDirection.contains("IMPOSSIBLE") && pathWithDownDirection.contains("IMPOSSIBLE")) {
            dpPath.put(index + ":" + curHeight, "IMPOSSIBLE");
            return dpPath.get(index + ":" + curHeight);
        } /**
         If DOWN choice doesn't lead to IMPOSSIBLE but UP choice does then :
         **/
        else if (!pathWithDownDirection.contains("IMPOSSIBLE") && pathWithUpDirection.contains("IMPOSSIBLE")) {
            dpPath.put(index + ":" + curHeight, pathWithDownDirection);
            return dpPath.get(index + ":" + curHeight);
        }
        /**
         If UP choice doesn't lead to IMPOSSIBLE but DOWN choice does then :
         **/
        else if (!pathWithUpDirection.contains("IMPOSSIBLE") && pathWithDownDirection.contains(("IMPOSSIBLE"))) {
            dpPath.put(index + ":" + curHeight, pathWithUpDirection);
            return dpPath.get(index + ":" + curHeight);
        }
        /**
         * If both of the choices leads to some path, then find the one with min height
         */

        else {
            minHeightPossibleWithUp = getMinHeightPossible(pathWithUpDirection, distances, index);
            minHeightPossibleWithDown = getMinHeightPossible(pathWithDownDirection, distances, index);
            if (minHeightPossibleWithUp <= minHeightPossibleWithDown) {
                dpPath.put(index + ":" + curHeight, pathWithUpDirection);
                return dpPath.get(index + ":" + curHeight);
            } else {
                dpPath.put(index + ":" + curHeight, pathWithDownDirection);
                return dpPath.get(index + ":" + curHeight);
            }
        }
    }

    /**
     * @param path      : optimal path obtained from index i to n
     * @param distances : input distance
     * @param index
     * @return
     */
    private static int getMinHeightPossible(String path, Integer distances[], int index) {
        int max = -1;
        char pathArray[] = path.toCharArray();
        int sum = 0;
        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i] == 'U') {
                sum += distances[index];
            } else {
                sum -= distances[index];
            }
            index++;
            max = Math.max(max, sum);
        }
        return max;
    }

}