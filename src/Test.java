

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Test {
    static int kth = 0;
    static int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        kth = 0;
        preOrder(root, k);
        return ans;

    }

    private void preOrder(TreeNode root, int k) {
        if (root != null) {
            preOrder(root.left, k);
            kth += 1;
            if (kth == k) ans = root.val;
            preOrder(root.right, k);

        }

    }

    public static void main(String[] args) {


    }
}