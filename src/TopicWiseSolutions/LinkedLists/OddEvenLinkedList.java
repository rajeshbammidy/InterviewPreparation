package TopicWiseSolutions.LinkedLists;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.LinkedLists|OddEvenLinkedList| on May,2020
 *  
 * Happy Coding :)
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
