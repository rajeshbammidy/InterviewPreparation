import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Main {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("hey");
            Pair pair = (Pair) obj;
            return this.x ==pair.x && this.y == pair.y;
        }
    }

    public static void main(String[] args) {
        HashMap<Pair, Integer> map = new HashMap<>();
        map.put(new Pair(1, 2), 1);
        System.out.println(map.containsKey(new Pair(1, 2)));
    }
}

