package ScalerAcademy.two_pointers;

import java.util.*;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.two_pointers / SmallestSequenceWithGivenPrimes
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given three prime number(A, B, C) and an integer D. Find the first(smallest) D integers which have only A, B, C or a combination of them as their prime factors.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A, B, C <= 10000
 *
 * 1 <= D <= 100000
 *
 *
 *
 * Input Format
 *
 * First argument is an integer A.
 * Second argument is an integer B.
 * Third argument is an integer C.
 * Fourth argument is an integer D.
 *
 *
 *
 * Output Format
 *
 * Return an integer array of size D, denoting the first D integers described above.
 *
 * NOTE: The sequence should be sorted in ascending order
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = 2
 * B = 3
 * C = 5
 * D = 5
 * Input 2:
 *
 * A = 3
 * B = 2
 * C = 7
 * D = 3
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [2, 3, 4, 5, 6]
 * Output 2:
 *
 * [2, 3, 4]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * 4 = A * A ( 2 * 2 ), 6 = A * B ( 2 * 3 )
 * Explanation 2:
 *
 * 2 has only prime factor 2. Similary 3 has only prime factor 3. 4 = A * A ( 2 * 2 )
 **/
public class SmallestSequenceWithGivenPrimes {

    static final int MAXN = 100001;
    static int spf[] = new int[MAXN];

    static void computerSmallestPrimeFactor() {
        for (int i = 0; i < MAXN; i++) {
            spf[i] = i;
            if (i > 2 && (i & 1) == 0) {
                spf[i] = 2;
            }
        }
        for (int i = 3; i <= Math.sqrt(MAXN); i++) {
            if (spf[i] == i) {
                for (long j = i * i; j < MAXN; j += i) {
                    spf[(int) j] = i;
                }
            }
        }
    }

    HashSet<Integer> getPrimeFactors(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            set.add(spf[n]);
            n /= spf[n];
        }
        return set;
    }

    public ArrayList<Integer> solve(int p1, int p2, int p3, int k) {
        ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(p1);
        minHeap.add(p2);
        minHeap.add(p3);

        int count = 0;
        while (count < k) {

            int currentNum = minHeap.poll();
            if (!finalAnswer.isEmpty() && currentNum == finalAnswer.get(finalAnswer.size() - 1)) continue;
            finalAnswer.add(currentNum);
            minHeap.add(currentNum * p1);
            minHeap.add(currentNum * p2);
            minHeap.add(currentNum * p3);
            count++;


        }
        return finalAnswer;
    }

    public static void main(String[] args) {

        System.out.println(new SmallestSequenceWithGivenPrimes().solve(3, 2, 7, 3));
        //System.out.println(new SmallestSequenceWithGivenPrimes().getPrimeFactors(15));
    }
}
