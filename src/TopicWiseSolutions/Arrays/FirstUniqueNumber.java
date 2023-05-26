package TopicWiseSolutions.Arrays;

import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|FirstUniqueNumber| on May,2020
 *  
 * Happy Coding :)
 *
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Example 2:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 *
 * Example 3:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 **/
public class FirstUniqueNumber {
    static class Node {
        Node prev, next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head, tail;
    HashMap<Integer, Node> map;
    HashMap<Integer, Integer> freqMap;

    public void addElement(int x) {
        /**
         * If the element is not repeated yet
         */
        if (!map.containsKey(x)) {
            Node newnode = new Node(x);
            if (head == null && tail == null) {
                head = tail = newnode;
                map.put(x, newnode);
                freqMap.put(x, 1);
            } else {
                tail.next = newnode;
                newnode.prev = tail;
                tail = newnode;
                map.put(x, newnode);
                freqMap.put(x, 1);
            }

        } else {
            /**
             * If the element already exists in the doubly linked list
             */
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);

        }
    }

    public void FirstUnique(int[] nums) {
        map = new HashMap<>();
        freqMap = new HashMap<>();

        for (int x : nums) {
            addElement(x);
        }
    }

    public int showFirstUnique() {
        if (head == null) return -1;
        if (freqMap.get(head.val) == 1) {
            return head.val;
        }
        while (head != null) {
            if (freqMap.get(head.val) == 1) {
                System.out.println(head.val);
                return head.val;
            }
            head = head.next;

        }
        if (head == null) {
            tail = null;

        }
        return -1;
    }

    public void add(int x) {
        addElement(x);
    }

}
