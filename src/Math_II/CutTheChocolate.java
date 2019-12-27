package Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_II|CutTheChocolate| on Dec,2019
 * Happy Coding :)
 *
 * Cut the Chocolate
 * Dipen has a chocolate of N by M pieces. He and Damini started playing with this chocolate. First Dipen takes the chocolate and divides it into two parts by making either a horizontal or a vertical cut. Then, Damini takes one of the available pieces and divides it into two parts by making either a horizontal or a vertical cut. Then Dipen do the same thing again and so on. The player who cannot make a turn loses. When all pieces are of size 1 * 1 player can not make a turn. Find who will win if both of them play optimally. Input:
 * Two integers denoting N and M.
 * Output:
 * Single integer. 1 if Dipen is going to win, 0 if Damini is going to win.
 * Constraints:
 * 1 <= N <= 10^9
 * 1 <= M <= 10^9
 * Example:
 * Input:
 * N = 1, M = 2
 *
 * Output:
 * 1
 *
 * Explanation:
 * There is only one possible move, so Damini even won't have a chance to make move.
 */
public class CutTheChocolate {
    public int solve(int a, int b) {
        if(a==1 && b==1)return 0;
        int tot=a*b-1;//these are the total vertical and horizontal cuts that we can make
        if(b==1)tot=a-1;
        if(tot%2==0)return 0;
        return 1;
    }
}
