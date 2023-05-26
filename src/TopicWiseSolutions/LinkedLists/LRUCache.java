package TopicWiseSolutions.LinkedLists;

import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.LinkedLists|LRUCache| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class LRUCache {
    static class node {
        node next;
        node prev;
        int val;

        public node(int val) {
            this.val = val;
        }
    }

    int cap = 0;
    int curCap = 0;
    //To store the int - node values
    HashMap<Integer, node> map;
    //To store the key -value pairs
    HashMap<Integer, Integer> valMap;
    node head, tail;

    /**
     * Initialize them
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        map = new HashMap<>();
        valMap = new HashMap<>();
        cap = capacity;
        curCap = 0;
        head = null;
        tail = null;
    }

    /**
     * Delete the least recently used page from the from and put in the back
     */
    void deleteAndPutBack(int key) {
        node temp = map.get(key);
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp == head) {
            head = head.next;
        }
        temp.next = null;

        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }

    /**
     * Return the key if it exists and delete from the front and put it in the back
     * else return -1
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            node temp = map.get(key);
            if (temp == tail || temp == tail && temp == head) return valMap.get(key);
            deleteAndPutBack(key);
            return valMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        /**
         * It is the new value we are inserting
         */
        if (!map.containsKey(key)) {
            //Its overflow
            if (curCap == cap) {

                map.remove(head.val);
                valMap.remove(head.val);
                head = head.next;
                node newnode = new node(key);
                newnode.prev = tail;
                tail.next = newnode;
                tail = newnode;
                map.put(key, newnode);
                valMap.put(key, value);


            } else {
                if (head == null && tail == null) {
                    node newnode = new node(key);
                    head = newnode;
                    tail = newnode;
                    map.put(key, newnode);
                    valMap.put(key, value);
                    curCap++;
                    return;

                }

                node newnode = new node(key);
                newnode.prev = tail;
                tail.next = newnode;
                tail = newnode;
                map.put(key, newnode);
                valMap.put(key, value);
                curCap++;

            }
        }
        /**
         * If that key already present inside the map
         */
        else {
            node temp = map.get(key);
            if (temp == tail) {
                valMap.put(key, value);
                return;
            }
            deleteAndPutBack(key);
            valMap.put(key, value);
        }


    }

    public static void main(String[] args) {

    }

}
