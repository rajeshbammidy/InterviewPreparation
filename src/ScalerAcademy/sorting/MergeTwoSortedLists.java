package ScalerAcademy.sorting;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / MergeTwoSortedLists
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Problem Description
 * Merge two sorted linked lists, A and B, and return it as a new list.
 *
 * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
 *
 *
 *
 * Problem Constraints
 * 0 <= |A|, |B| <= 105
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 *
 * The second argument of input contains a pointer to the head of linked list B.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the merged linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 5 -> 8 -> 20
 * B = 4 -> 11 -> 15
 * Input 2:
 *
 * A = 1 -> 2 -> 3
 * B = Null
 *
 *
 * Example Output
 * Output 1:
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Output 2:
 *
 * 1 -> 2 -> 3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Explanation 2:
 *
 * We don't need to merge as B is empty.
 **/

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode listA, ListNode listB) {
        ListNode temp = null;
        ListNode start = null;
        while (listA != null && listB != null) {
            int value = -1;
            if (listA.val <= listB.val) {
                value = listA.val;
                listA = listA.next;
            } else {
                value = listB.val;
                listB = listB.next;
            }
            if (temp == null) {
                temp = new ListNode(value);
                start = temp;
                continue;
            }
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        while (listA != null) {
            temp.next = new ListNode(listA.val);
            temp = temp.next;
            listA = listA.next;
        }
        while (listB != null) {
            temp.next = new ListNode(listB.val);
            temp = temp.next;
            listB = listB.next;
        }
        return start;
    }

}
