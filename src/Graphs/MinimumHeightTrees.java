package Graphs;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|MinimumHeightTrees| on Aug,2020
 *  
 * Happy Coding :)
 *
 * 310. Minimum Height Trees
 **/

import  java.util.*;
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            ArrayList<Integer> leaves = new ArrayList<>();
            leaves.add(0);
            return leaves;

        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        ArrayList<Integer> leaves = findLeaves(list);
        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (int x : leaves) {
                int adj = list.get(x).get(0);
                list.get(x).remove(0);
                list.get(adj).remove(new Integer(x));
                if (list.get(adj).size() == 1) newLeaves.add(adj);
            }
            leaves = newLeaves;

        }
        return leaves;

    }

    private ArrayList<Integer> findLeaves(ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> lv = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 1) lv.add(i);

        }
        return lv;
    }

}
