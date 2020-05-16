

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


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

public class Test {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode evenHead = null;
        ListNode evenptr = null;
        ListNode oddHead = null;
        ListNode oddptr = null;
        int c = 1;
        while (head != null) {
            if (c % 2 == 0) {
                if (evenHead == null) {
                    evenHead = head;
                    evenptr = head;
                    head = head.next;
                    c++;
                    continue;
                }
                evenptr.next = head;
                evenptr = evenptr.next;


            } else {

                if (oddHead == null) {
                    oddHead = head;
                    oddptr = head;
                    head = head.next;
                    c++;
                    continue;
                }
                oddptr.next = head;
                oddptr = oddptr.next;


            }
            head = head.next;
            c++;
        }
        evenptr.next=null;
        if (evenHead != null) {
            oddptr.next = evenHead;
        }
        return oddHead;


    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode ptr = node;
        for (int i = 2; i <= 3; i++) {
            ptr.next = new ListNode(i, null);
            ptr = ptr.next;
        }

        ptr = new Test().oddEvenList(node);
        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }

    }
}