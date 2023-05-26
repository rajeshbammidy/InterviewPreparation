package TopicWiseSolutions.Queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Project: InterviewPreparation
 * Package: TopicWiseSolutions.Strings.Queue / QueueReconstructionByHeight
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * LC 406: https://leetcode.com/problems/queue-reconstruction-by-height/
 **/
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        //sort in descending order when the k is not equal, when k is equal then sort those elements in ascending order
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int p[] : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[][]{});

    }

    public static void main(String[] args) {

    }
}
