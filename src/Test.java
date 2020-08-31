
import java.util.*;


public class Test {
    int ans = Integer.MIN_VALUE;

    public int largestComponentSize(int[] arr) {
        boolean visited[] = new boolean[arr.length];

        bactrack(arr, visited, new Stack<Integer>());
        return ans;

    }

    private void bactrack(int[] arr, boolean[] visited, Stack<Integer> stack) {
        ans = Math.max(ans, stack.size());

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                if (stack.isEmpty()) {
                    visited[i] = true;
                    stack.push(arr[i]);
                    bactrack(arr, visited, stack);
                    stack.pop();
                    visited[i] = false;
                } else {
                    int a = stack.peek();
                    int gcd = findGCD(a, arr[i]);
                    if (gcd > 1) {
                        stack.push(arr[i]);
                        visited[i] = true;
                        bactrack(arr, visited, stack);
                        stack.pop();
                        visited[i] = false;

                    }
                }
            }
        }


    }

    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    private void flipList(int i, int j, ArrayList<Integer> olist) {
        while (i < j) {
            int temp = olist.get(i);
            olist.set(i, olist.get(j));
            olist.set(j, temp);
            i++;
            j--;

        }
    }

    public static void main(String[] args) {

/**
 *
 * Example call
 *lordOfRing(new int[]{5,10,-5});
 */
    }

}