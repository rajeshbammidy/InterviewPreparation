package Math_II;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Math_II|RectangleArea| on Dec,2019
 * Happy Coding :)
 */
public class RectangleArea {
    public int solve(int l1x, int l1y, int r1x, int r1y, int l2x, int l2y, int r2x, int r2y) {
        /**
         * If there is no overlap then return 0
         */
        if (!(l1x < r2x && l1y < r2y && l2x < r1x && l2y < r1y)) return 0;

        /**
         * Else find the area
         */
        int inx = Math.abs(Math.min(r1x, r2x) - Math.max(l1x, l2x));
        int iny = Math.abs(Math.min(r1y, r2y) - Math.max(l1y, l2y));

        int inarea = inx * iny;
        return inarea;
    }
}
