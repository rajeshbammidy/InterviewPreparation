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
            return this.x == pair.x && this.y == pair.y;
        }
    }


    static int unique_digit(int n) {
        int a[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int r, pos = 0;
        while (n > 0) {
            r = n % 10;
            if (a[r] == -1)
                a[r] = pos;
            else
                return a[r];
            pos++;
            n /= 10;
        }
        return -1;
    }

    static void countNumbers(List<List<Integer>> arr) {
        for (List<Integer> list : arr) {
            int start = list.get(0);
            int end = list.get(1);
            int count = 0;
            for (int i = start; i <= end; ++i) {
                int pos = unique_digit(i);
                if (pos == -1) {
                    count++;
                    continue;
                } else if (pos == 0)
                    continue;
                int x = (int) Math.pow(10, pos);
                int y = i % x;

                i = i + (x - y) - 1;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        int b= 'b'-'B';
        System.out.println((int)('A'));
        System.out.println((int)('a'));
        System.out.println((char) (65+25));
        System.out.println(b);
    }
}

