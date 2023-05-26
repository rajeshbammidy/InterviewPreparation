package TopicWiseSolutions.LinkedLists;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.LinkedLists|SortList| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preSlow = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = null;
        return mergeSort(sortList(head), sortList(slow));

    }

    private ListNode mergeSort(ListNode s1, ListNode s2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (s1 != null && s2 != null) {
            if (s1.val < s2.val) {
                cur.next = s1;
                s1 = s1.next;
            } else {
                cur.next = s2;
                s2 = s2.next;
            }


            cur=cur.next;
        }
        if (s1 == null) {
            cur.next = s2;
        } else {
            cur.next = s1;
        }
        dummy = dummy.next;
        return dummy;
    }
}
