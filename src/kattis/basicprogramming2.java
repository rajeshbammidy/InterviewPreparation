package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class basicprogramming2 {
    public static void main(String[] args) throws Exception {
        /**
         * Read the input
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nAndT[] = bf.readLine().split("\\s");
        Integer inputArray[] = Arrays.stream(bf.readLine().split("\\s")).map(x -> Integer.parseInt(x)).toArray(Integer[]::new);
        switch (Integer.parseInt(nAndT[1])) {
            case 1:
                findIfSumExists(inputArray, 7777);
                break;
            case 2:
                checkIfUniqueElements(inputArray);
                break;
            case 3:
                checkIfElementAppearsMoreThanN2Time(inputArray);
                break;
            case 4:
                printMedian(inputArray);
                break;
            case 5:
                printSortedOrder(inputArray);
                break;
        }

    }

    /**
     * @param inputArray: Given input array
     */
    private static void printSortedOrder(Integer[] inputArray) {

        boolean isFirst = false;
        List<Integer> elements = new ArrayList<>();
        for (int x : inputArray) {
            if (x >= 100 && x <= 999) {
                elements.add(x);
            }
        }
        Collections.sort(elements);
        for (int x : elements) {
            if (x >= 100 && x <= 999) {
                if (!isFirst) {
                    System.out.print(x);
                    isFirst = true;
                } else {
                    System.out.print(" " + x);
                }

            }
        }
    }

    /**
     * @param inputArray: Given input array
     */
    private static void printMedian(Integer[] inputArray) {
        int n = inputArray.length;
        Arrays.sort(inputArray);
        int mid = n / 2;
        /**
         * if n is even
         */
        if ((n & 1) == 0) {

            System.out.println(inputArray[mid - 1] + " " + inputArray[mid]);
        } else {
            System.out.println(inputArray[mid]);
        }
    }

    /**
     * @param inputArray: Given input array
     */
    private static void checkIfElementAppearsMoreThanN2Time(Integer[] inputArray) {
        /**
         * Algorithm: For every two unequal elements remove the two elements
         */
        int count = 1;
        int index = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] == inputArray[index]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                index = i;
                count = 1;
            }

        }
        count = 0;
        for (int x : inputArray) {
            if (x == inputArray[index]) count++;
        }
        if (count > inputArray.length / 2) {
            System.out.println(inputArray[index]);
        } else {
            System.out.println(-1);
        }
    }

    /**
     * @param inputArray: Given input array
     */
    private static void checkIfUniqueElements(Integer[] inputArray) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : inputArray) {
            if (set.contains(element)) {
                System.out.println("Contains duplicate");
                return;
            }
            set.add(element);
        }
        System.out.println("Unique");
    }

    /**
     * @param inputArray : Given input
     * @param sum        : sum to check if exists
     */
    private static void findIfSumExists(Integer[] inputArray, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : inputArray) {
            if (set.contains(element)) {
                System.out.println("Yes");
                return;
            }
            set.add(sum - element);
        }
        System.out.println("No");
    }
}





