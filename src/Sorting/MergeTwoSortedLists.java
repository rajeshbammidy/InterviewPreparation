package Sorting;

import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|MergeTwoSortedLists| on May,2020
 *  
 * Happy Coding :)
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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head = new ListNode(0);
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode ptr = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ptr.next = new ListNode(p1.val);
                ptr = ptr.next;
                p1 = p1.next;
            } else {
                ptr.next = new ListNode(p2.val);
                ptr = ptr.next;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            ptr.next = p2;
        }

        if (p2 == null) {
            ptr.next = p1;
        }
        head = head.next;
        return head;
    }
}
