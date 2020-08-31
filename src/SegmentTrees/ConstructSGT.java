package SegmentTrees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|SegmentTrees|ConstructSGT| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class ConstructSGT {
    static int tree[];

    public static void main(String[] args) {
        int arr[] = new int[100];
        int n = arr.length;
        tree = new int[4 * n];
        construct(tree, arr, 0, n - 1, 0);

    }

    /**
     * @param tree segment tree array
     * @param arr  given array
     * @param ss   starting index of arr
     * @param se   ending index of arr
     * @param si   starting index of segment tree
     * @return
     */
    private static int construct(int[] tree, int[] arr, int ss, int se, int si) {
        /**
         * If it is the leaf node then return it
         */
        if (ss == se) {
            tree[si] = arr[se];
            return tree[si];
        }
        /**
         * Find the mid and propagate further
         */
        int mid = (ss + se) / 2;
        tree[si] = construct(tree, arr, ss, mid, 2 * si + 1) + construct(tree, arr, mid + 1, se, 2 * si + 2);
        return tree[si];
    }

    /**
     * @param tree segment tree
     * @param qs   queryStart index
     * @param qe   queryEnd index
     * @param ss   starting index of arr
     * @param se   ending index of arr
     * @param si   starting index of segment tree
     * @return
     */
    public static int getSum(int tree[], int qs, int qe, int ss, int se, int si) {
        /**
         * If the query range is out of bounds
         */
        if (qs > se || qe < ss || ss > se) return 0;
        /*
        If the current range lies completely inside query range
         */
        if (qs <= ss && qe >= se) return tree[si];
        int mid = (ss + se) / 2;
        return getSum(tree, qs, qe, ss, mid, 2 * si + 1) + getSum(tree, qs, qe, ss, mid, 2 * si + 2);
    }

    /**
     * @param tree  segment tree
     * @param ss    starting index of arr
     * @param se    ending index of arr
     * @param si    starting index of segment tree
     * @param index The index at which you want to update
     * @param diff  The value with which you want to update
     */
    public static void updateQuery(int tree[], int ss, int se, int si, int index, int diff) {
        /**
         * If the index lies outside the range
         */
        if (index < ss || index > se) return;
        tree[si] += diff;
        if (ss < se) {
            int mid = (ss + se) / 2;
            updateQuery(tree, ss, mid, 2 * si + 1, index, diff);
            updateQuery(tree, mid + 1, se, 2 * si + 2, index, diff);
        }
    }
}
