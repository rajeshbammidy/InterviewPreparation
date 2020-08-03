package BST;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BST|CeilBST| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Given an array arr[] of N positive integers to be inserted into BST and a number X. The task it to find Ceil of X.
 * Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
 *
 * Input:
 * The first line of input contains the number of test cases T. For each test case, first line of input contains number of elements in the BST, i.e N. Next line contains N elements to be inserted into BST and the last line contains X.
 *
 * Output:
 * For each test case, print the smallest element in BST which is larger than X.
 *
 * Your task:
 * No need to worry about insert function in BST. Just complete the function findCeil() to implement ceil in BST.
 *
 * Expected Time Complexity: O(Height of the BST)
 * Expected Auxiliary Space: O(Height of the BST).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 1 <= arr[i] <= 105
 *
 * Example:
 * Input:
 * 2
 * 5
 * 5 7 1 2 3
 * 3
 * 6
 * 10 5 11 4 7 8
 * 6
 *
 * Output:
 * 3
 * 7
 *
 * Explanation:
 * Testcase 1: We find 3 in BST, so ceil of 3 is 3.
 * Testcase 2: We find 7 in BST, so ceil of 6 is 7.
 **/
public class CeilBST {
    int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        int res = -1;
        while (root != null) {
            if (root.data == key) return key;

            if (key < root.data) {
                res = root.data;
                root = root.left;
            } else root = root.right;


        }
        return res;
    }
}
