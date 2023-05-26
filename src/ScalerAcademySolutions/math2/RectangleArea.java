package ScalerAcademySolutions.math2;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_II / RectangleArea
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 * Given eight integers A, B, C, D, E, F, G, and H, which represent two rectangles in a 2D plane.
 *
 * For the first rectangle, its bottom left corner is (A, B), and the top right corner is (C, D), and for the second rectangle, its bottom left corner is (E, F), and the top right corner is (G, H).
 *
 * Find and return the overlapping area of the two rectangles.
 *
 *
 *
 * Problem Constraints
 * -104 <= A <= C <= 104
 * -104 <= B <= D <= 104
 * -104 <= E <= G <= 104
 * -104 <= F <= H <= 104
 *
 *
 * Input Format
 * The eight arguments given are the integers A, B, C, D, E, F, G and H.
 *
 *
 *
 * Output Format
 * Return the overlapping area of the two rectangles.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 0   B = 0
 * C = 4   D = 4
 * E = 2   F = 2
 * G = 6   H = 6
 * Input 2:
 *
 * A = 0   B = 0
 * C = 4   D = 4
 * E = 2   F = 2
 * G = 3   H = 3
 *
 *
 * Example Output
 * Output 1:
 *
 * 4
 * Output 2:
 *
 * 1
 */
public class RectangleArea {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        //find the width
        int width = Math.min(C, G) - Math.max(A, E);
        if (width < 0) return 0;

        //find the height
        int height = Math.min(D, H) - Math.max(B, F);
        if (height < 0) return 0;
        return width * height;

    }

}
