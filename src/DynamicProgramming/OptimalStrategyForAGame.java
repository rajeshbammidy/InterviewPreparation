package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OptimalStrategyForAGame {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public String toString() {
            return "{ " + first + ", " + second + " }";
        }
    }

    static int getMaxScore(int pots[]) {

        Pair[][] moves = new Pair[pots.length][pots.length];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                moves[i][j] = new Pair();
            }
        }

        for (int i = 0; i < pots.length; i++) {
            moves[i][i].first = pots[i];

        }

        for (int l = 1; l < pots.length; l++) {
            for (int i = 0; i < pots.length - l; i++) {
                int j = i + l;
                if (pots[i] + moves[i + 1][j].second > moves[i][j - 1].second + pots[j]) {
                    moves[i][j].first = pots[i] + moves[i + 1][j].second;
                    moves[i][j].second = moves[i + 1][j].first;

                } else {
                    moves[i][j].first = pots[j] + moves[i][j - 1].second;
                    moves[i][j].second = moves[i][j - 1].first;

                }
            }
        }

        return moves[0][moves.length - 1].first;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            bf.readLine();


            String iws[] = bf.readLine().split("\\s");
            int wt[] = new int[iws.length];
            for (int j = 0; j < wt.length; j++) {
                wt[j] = Integer.parseInt(iws[j]);
            }
            System.out.println(getMaxScore(wt));
        }
    }
}
