package Graphs;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|ReconstructItinerary| on Aug,2020
 *  
 * Happy Coding :)
 * 332. Reconstruct Itinerary
 **/
import java.util.*;
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            String src = tickets.get(i).get(0);
            String des = tickets.get(i).get(1);
            if (map.containsKey(src)) {
                map.get(src).add(des);
            } else {
                map.put(src, new PriorityQueue<>());
                map.get(src).add(des);
            }

        }

        Stack<String> stack = new Stack<>();
        ArrayList<String> res = new ArrayList<>();

        dfs("JFK", map, stack);

        while (stack.size()>0)res.add(stack.pop());
        return res;


    }

    private void dfs(String src, HashMap<String, PriorityQueue<String>> map, Stack<String> stack) {

        PriorityQueue<String> q = map.get(src);
        while (q != null && q.size() > 0) {
            String to = q.poll();
            dfs(to, map, stack);
        }
        stack.push(src);


    }
}
