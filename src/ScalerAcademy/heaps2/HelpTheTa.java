package ScalerAcademy.heaps2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.heaps2
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Ayush has recently joined InterviewBit Academy as TA (Teaching Assistant). He has been assigned a job to keep record of all the errors each student is having in his batch and report it to the Mentor.
 *
 * Since, the mentor gives extra attention to weak students, he resolves the issues of student having maximum number of errors first. But, to keep equality among students, he gives one minute to each student to resolve one of his errors and then ask the TA for next student.
 *
 * Also, the lecture would not last more than B minutes and whenever a student has no more errors left, he leaves the lecture immediately.
 *
 * Ayush, being confused each time, needs your help to shout out the roll number of student who should be helped at any time i.
 * You are given an array of integers, where A[i] denotes number of errors in code of student with roll number i.
 * Return a list containing the roll numbers,where element at index i denotes the roll number to be helped at minute i.
 * Ayush should keep on shouting roll numbers unless the B minutes are over or, the class is empty(everyone has left).
 *
 * HINT: The returning array size will depend on the time till which roll numbers are shouted.
 *
 * NOTE
 *
 * 1. Roll Numbers are 0-indexed (i.e, Roll numbers start from 0)
 *
 * 2. In case of tie(same number of errors), the least roll number is given preference.
 *
 * 3. There is no restriction on spending more than one minute consecutively on one student, as far as the mentor's condtions are met
 *
 * 4. Your code will be run on multiple test cases(<=10), try to come up with optimised solution.
 *
 * Constraints
 *
 * 1 <= Number of Students <= 10^6
 * 0 <= A[i] : Errors for each student <= 10^5
 * 0 <= Sum of All Errors <= 10^6
 * 1 <= B <= 10^6
 * Sample Input
 *
 * 4 2 5 3 6
 * 4
 * Sample Output
 *
 * 4 2 4 0
 * Explanation
 *
 * At i-th minute, the roll number to be help is announced :
 * 0th minute: Roll 4 is having 6 errors
 * 1st minute: Roll 2 and 4 are having 5 errors
 * 2nd minute: Roll 4 is having 5 errors
 * 3rd minute: Roll 0, 2 and 4 are having 4 errors
 * 4th minute: Lecture ends!
 * So output would be [4 2 4 0]
 */
public class HelpTheTa {
    static class Node {
        public Node(int index, int doubts) {
            this.index = index;
            this.doubts = doubts;
        }

        int index, doubts;

    }

    public ArrayList<Integer> solve(ArrayList<Integer> list, int minutes) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((Node o1, Node o2) -> {
            if (o1.doubts != o2.doubts) return -new Integer(o1.doubts).compareTo(o2.doubts);
            return new Integer(o1.index).compareTo(o2.index);
        });
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==0)continue;
            maxHeap.add(new Node(i, list.get(i)));
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (minutes-- > 0 && !maxHeap.isEmpty()) {

            Node node = maxHeap.poll();
            res.add(node.index);
            node.doubts -= 1;
            if (node.doubts == 0) continue;
            maxHeap.add(new Node(node.index, node.doubts));
        }
        return res;


    }
    public static void main(String[] args) {
        System.out.println(new HelpTheTa().solve(new ArrayList<>(Arrays.asList(4, 2, 5, 3, 6)), 4));
        ;
    }

}
