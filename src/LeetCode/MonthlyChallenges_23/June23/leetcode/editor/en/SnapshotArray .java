package LeetCode.FEB23.leetcode.editor.en;

/**
 * Implement a SnapshotArray that supports the following interface:
 *
 *
 * SnapshotArray(int length) initializes an array-like data structure with the
 * given length. Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total
 * number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we
 * took the snapshot with the given snap_id
 *
 *
 *
 * Example 1:
 *
 *
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation:
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 *
 *
 * Constraints:
 *
 *
 * 1 <= length <= 5 * 10⁴
 * 0 <= index < length
 * 0 <= val <= 10⁹
 * 0 <= snap_id < (the total number of times we call snap())
 * At most 5 * 10⁴ calls will be made to set, snap, and get.
 *
 *
 * Related Topics Array Hash Table Binary Search Design 👍 3332 👎 432
 */

import java.util.*;

class SnapshotArray1 {
    public static void main(String args[]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        System.out.println(map.lowerKey(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class SnapshotArray {

        ArrayList<TreeMap<Integer, Integer>> list = new ArrayList<>();
        int currentSnap = 0;

        public SnapshotArray(int length) {
            currentSnap = 0;
            for (int i = 0; i < length; i++) {
                list.add(new TreeMap<>());
            }

        }

        public void set(int index, int val) {
            list.get(index).put(currentSnap, val);

        }

        public int snap() {
            currentSnap++;
            return currentSnap - 1;

        }

        public int get(int index, int snap_id) {
            if (list.get(index).get(snap_id) == null) {
                Integer key = list.get(index).lowerKey(snap_id);
                if(key==null)return 0;
                return list.get(index).getOrDefault(key, 0);
            }
            return list.get(index).getOrDefault(snap_id, 0);

        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
