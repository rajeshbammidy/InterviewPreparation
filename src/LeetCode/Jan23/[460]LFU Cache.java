package LeetCode.Jan23;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data
 * structure.
 * int get(int key) Gets the value of the key if the key exists in the cache.
 * Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or
 * inserts the key if not already present. When the cache reaches its capacity, it should
 * invalidate and remove the least frequently used key before inserting a new item.
 * For this problem, when there is a tie (i.e., two or more keys with the same
 * frequency), the least recently used key would be invalidated.
 *
 *
 * To determine the least frequently used key, a use counter is maintained for
 * each key in the cache. The key with the smallest use counter is the least
 * frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due
 * to the put operation). The use counter for a key in the cache is incremented
 * either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
 * "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is
 * most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest,
 * invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 * // cache=[4,3], cnt(4)=2, cnt(3)=3
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= capacity <= 10⁴
 * 0 <= key <= 10⁵
 * 0 <= value <= 10⁹
 * At most 2 * 10⁵ calls will be made to get and put.
 *
 *
 *
 *
 *
 * Related Topics Hash Table Linked List Design Doubly-Linked List 👍 4579 👎 284
 */

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache460 {
    /**
     * Instead of using DLL we have used LinkedHashSet for the easier implementation.
     * Removal of an element from LinkedHashSet takes O(1)
     * Insertion of an element from LinkedHashSet takes O(1)
     * And also it preserves the insertion order, unlike hashset
     */
    private int capacity = 0;

    private int minFreq = 0;
    /**
     * Stores key and its respective value
     */
    private HashMap<Integer, Integer> keyToValueMap;
    /**
     * Stores key and its respective freq
     */
    private HashMap<Integer, Integer> keyToFreqMap;
    /**
     * Stores freq and its associated values
     */
    private HashMap<Integer, LinkedHashSet<Integer>> freqToListMap;

    public LFUCache460(int capacity) {
        /**
         * Initialize all the instance variables here
         */
        this.capacity = capacity;
        minFreq = 0;
        keyToValueMap = new HashMap<>();
        keyToFreqMap = new HashMap<>();
        freqToListMap = new HashMap<>();
    }

    public int get(int key) {
        /**
         * If the value is not in the keyToValueMap return -1
         */
        if (!keyToValueMap.containsKey(key)) return -1;
        /**
         * Get the current freq of the key
         */
        int currentFreq = keyToFreqMap.get(key);
        /**
         * Since we have to increase the freq remove the element from current freq list
         */
        freqToListMap.get(currentFreq).remove(key);
        /**
         * If all the elements from the min freq are removed, update the minFreq
         */
        if (currentFreq == minFreq && freqToListMap.get(currentFreq).isEmpty()) {
            minFreq++;
            freqToListMap.remove(currentFreq);
        }
        freqToListMap.putIfAbsent(currentFreq + 1, new LinkedHashSet<>());
        freqToListMap.get(currentFreq + 1).add(key);
        keyToFreqMap.put(key, currentFreq + 1);
        return keyToValueMap.get(key);

    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyToValueMap.containsKey(key)) {
            keyToValueMap.put(key, value);
            get(key);
            return;
        }

        /**
         * If the capacity is equal to keyToValueMap size
         */
        if (capacity == this.keyToValueMap.size()) {
            /**
             * Remove the LRU element from the list
             */
            if (freqToListMap.get(minFreq).iterator().hasNext()) {
                int valueToRemove = freqToListMap.get(minFreq).iterator().next();
                System.out.println();
                freqToListMap.get(minFreq).remove(valueToRemove);
                keyToValueMap.remove(valueToRemove);
                keyToFreqMap.remove(valueToRemove);
            }


        }
        minFreq = 1;
        freqToListMap.putIfAbsent(minFreq, new LinkedHashSet<>());
        freqToListMap.get(minFreq).add(key);
        keyToFreqMap.put(key, minFreq);
        keyToValueMap.put(key, value);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
