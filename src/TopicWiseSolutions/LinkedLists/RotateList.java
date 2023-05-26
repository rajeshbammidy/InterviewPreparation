package TopicWiseSolutions.LinkedLists;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.LinkedLists|RotateList| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode ptr = head;
        if (k == 0 || head == null) return head;
        while (ptr != null) {
            deque.addLast(ptr.val);
            ptr = ptr.next;
        }
        k = k % deque.size();
        while (k > 0) {
            deque.addFirst(deque.pollLast());
            k--;
        }
        ptr = head;
        while (ptr != null) {
            ptr.val = deque.pollFirst();
            ptr = ptr.next;
        }
        return head;

    }
}
