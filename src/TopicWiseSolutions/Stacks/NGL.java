package TopicWiseSolutions.Stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Stacks|NGL| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class NGL {
    public static int[] getNGL(int arr[]) {
        int ans[] = new int[arr.length];
        ans[0] = -1;
        int i = arr.length - 1;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0) {

            while (i - 1 >= 0 && arr[i] > arr[i - 1]) {
                stack.add(i);
                i--;
            }
            if (i - 1 >= 0) {
                ans[i] = arr[i - 1];
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i - 1]) {
                    ans[stack.pop()] = arr[i - 1];
                }
            }
            i = i - 1;
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNGL(new int[]{1, 5, 7, 8, 1, 1, 0, 1, 6})));
    }
}
