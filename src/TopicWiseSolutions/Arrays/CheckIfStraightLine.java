package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|CheckIfStraightLine| on May,2020
 *  
 * Happy Coding :)
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 *    Hide Hint #1
 * If there're only 2 points, return true.
 *    Hide Hint #2
 * Check if all other points lie on the line defined by the first 2 points.
 *    Hide Hint #3
 * Use cross product to check collinearity.
 **/
public class CheckIfStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        for (int i = 0; i < coordinates.length - 2; i++) {
            int x1 = coordinates[i][0];
            int y1 = coordinates[i][1];
            int x2 = coordinates[i + 1][0];
            int y2 = coordinates[i + 1][1];
            int x3 = coordinates[i + 2][0];
            int y3 = coordinates[i + 2][1];

            int lhs = (y2 - y1) * (x3 - x2);
            int rhs = (y3 - y2) * (x2 - x1);
            if (lhs != rhs) return false;
        }
        return true;

    }

}
