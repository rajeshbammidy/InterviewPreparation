package ScalerAcademy.heaps1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.heaps1
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given a list containing head pointers of N sorted linked lists.
 * Merge these given sorted linked lists and return them as one sorted list.
 *
 *
 *
 * Problem Constraints
 * 1 <= total number of elements in given linked lists <= 100000
 *
 *
 *
 * Input Format
 * The first and only argument is a list containing N head pointers.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the sorted linked list after merging all the given linked lists.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * Input 2:
 *
 * 10 -> 12
 * 13
 * 5 -> 6
 *
 *
 * Example Output
 * Output 1:
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * Output 2:
 *
 * 5 -> 6 -> 10 -> 12 ->13
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
 * Explanation 2:
 *
 * The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
 */
public class MergeKSortedLists {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> list) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return new Integer(o1.val).compareTo(o2.val);
            }
        });
        list.stream().forEach(x -> minHeap.add(x));
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            ListNode next = node.next;
            temp.next = node;
            temp = temp.next;
            node.next = null;
            if (next != null) minHeap.add(next);
        }
        head = head.next;
        return head;

    }

    public static void main(String[] args) {

    }
}
