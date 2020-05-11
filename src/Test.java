

import com.sun.deploy.util.ArrayUtil;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */
public class Test {

    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int rows[] = new int[]{-1, 0, 1, 0};
        int cols[] = new int[]{0, 1, 0, -1};
        int m = image.length;
        int n = image[0].length;

        Queue<node> queue = new LinkedList<>();
        queue.add(new node(sr, sc));
        int target = image[sr][sc];
        image[sr][sc] = -1;
        while (!queue.isEmpty()) {
            node temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {

                if (isValid(x + rows[i], y + cols[i], m, n) && image[x + rows[i]][y + cols[i]] == target) {
                    image[x + rows[i]][y + cols[i]] = -1;
                    queue.add(new node(x + rows[i], y + cols[i]));
                }

            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == -1) image[i][j] = newColor;
            }
        }
        return image;


    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;

    }


    public static void main(String[] args) {
        int arr[][] = new int[][]{{0, 0, 0}, {0, 1, 1}};
        System.out.println(Arrays.deepToString(new Test().floodFill(arr, 1, 1, 1)));


    }
}