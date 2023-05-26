package ScalerAcademySolutions.stacks;


import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 *
 *
 *
 * Output Format
 * Return 0, if the linked list is not a palindrome.
 *
 * Return 1, if the linked list is a palindrome.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 2, 1]
 * Input 2:
 *
 * A = [1, 3, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
 * Explanation 2:
 *
 * The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 */

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PalindromeList {

    public int lPalin(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (head.val != stack.peek()) return 0;
            head = head.next;
            stack.pop();
        }
        return 1;
    }
}
