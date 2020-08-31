package SegmentTrees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|SegmentTrees|SegmentTreeWithLazyPropagation| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class SegmentTreeWithLazyPropagation {
    static int tree[];
    static int lazy[];

    public static void main(String[] args) {
        int arr[] = new int[100];
        int n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
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
     * @param tree segment tree array
     * @param lazy lazy tree array
     * @param ss   starting index of arr
     * @param se   ending index of arr
     * @param qs   query starting index
     * @param qe   query ending index
     * @param si   starting index of segment tree
     * @param val  the value with which you want to update
     */
    public static void updateRangeQuery(int tree[], int lazy[], int ss, int se, int qs, int qe, int si, int val) {

        if (qs > se || qe < ss || ss > se) return;
        if (lazy[si] != 0) {
            tree[si] += (se - ss + 1) * lazy[si];
            if (ss != se) {
                lazy[2 * si + 1] += lazy[si];
                lazy[2 * si + 2] += lazy[si];
            }
            lazy[si] = 0;
        }

        if (qs <= ss && qe >= se) {
            tree[si] += (se - ss + 1) * val;
            if (ss != se) {
                lazy[2 * si + 1] += val;
                lazy[2 * si + 2] += val;
            }
        }

        int mid = (ss + se) / 2;
        updateRangeQuery(tree, lazy, ss, mid, qs, qe, 2 * si + 1, val);
        updateRangeQuery(tree, lazy, mid + 1, se, qs, qe, 2 * si + 2, val);
        tree[si] = tree[2 * si + 1] + tree[2 * si + 2];

    }

    public static int getSum(int arr[], int lazy[], int qs, int qe, int ss, int se, int si) {
        if (lazy[si] != 0) {
            tree[si] += (se - ss + 1) * lazy[si];
            if (ss != se) {
                lazy[2 * si + 1] += lazy[si];
                lazy[2 * si + 2] += lazy[si];
            }
            lazy[si] = 0;
        }

        if (qs <= ss && qe >= se) return tree[si];
        int mid = (ss + se) / 2;
        return getSum(arr, lazy, qs, qe, ss, mid, 2 * si + 1) + getSum(arr, lazy, qs, qe, mid + 1, se, 2 * si + 2);

    }
}
