package ScalerAcademySolutions.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class MaximumRectangle {
    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        int max = Integer.MIN_VALUE;
        int m = matrix.size(), n = matrix.get(0).size();
        ArrayList<ArrayList<Integer>> cSum = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            cSum.add(new ArrayList<>(Arrays.asList(new Integer[matrix.get(i).size()])));
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    cSum.get(i).set(j, matrix.get(i).get(j));
                } else {
                    int sum = matrix.get(i).get(j) == 0 ? 0 : cSum.get(i - 1).get(j)+matrix.get(i).get(j);
                    cSum.get(i).set(j, sum);
                }
            }
            System.out.println(cSum.get(i));
            max = Math.max(max, largestRectangleArea(cSum.get(i)));
        }

        return max;
    }

    public int largestRectangleArea(ArrayList<Integer> list) {
        ArrayList<Integer> lSmall = getLeftSmallIndexArray(list);
        ArrayList<Integer> rSmall = getRightSmallIndexArray(list);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lSmall.size(); i++) {
            max = Math.max(max, (rSmall.get(i) - lSmall.get(i) - 1) * list.get(i));
        }
        return max;
    }

    private ArrayList<Integer> getRightSmallIndexArray(ArrayList<Integer> list) {
        Stack<Integer> indexStack = new Stack<>();
        ArrayList<Integer> rSmallIndex = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
        Collections.fill(rSmallIndex, list.size());
        for (int i = 0; i < list.size(); i++) {

            while (!indexStack.isEmpty() && list.get(i) < list.get(indexStack.peek())) {
                rSmallIndex.set(indexStack.pop(), i);
            }
            indexStack.push(i);
        }


        return rSmallIndex;
    }

    private ArrayList<Integer> getLeftSmallIndexArray(ArrayList<Integer> list) {
        Stack<Integer> indexStack = new Stack<>();
        ArrayList<Integer> lSmallIndex = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
        Collections.fill(lSmallIndex, -1);
        for (int i = list.size() - 1; i >= 0; i--) {

            while (!indexStack.isEmpty() && list.get(i) < list.get(indexStack.peek())) {
                lSmallIndex.set(indexStack.pop(), i);
            }
            indexStack.push(i);
        }


        return lSmallIndex;
    }

    public static void main(String[] args) {
        int arr[][]={
                {0, 1, 1},
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            list.add(new ArrayList<>());
            for (int j = 0; j <arr[i].length ; j++) {
                list.get(i).add(arr[i][j]);
            }
        }

        System.out.println(new MaximumRectangle().solve(list));
    }
}
