package ScalerAcademy.math_I;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_I / DivisorGame
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

public class DivisorGame {

    public int solve(int A, int B, int C) {
        HashSet<Integer> set = new HashSet<Integer>();
        int multiplier = 1;
        while (B * multiplier <= A) {
            if ((B * multiplier) % C == 0) set.add(B * multiplier);
            multiplier++;

        }
        multiplier = 1;
        while (C * multiplier <= A) {
            if ((C * multiplier) % B == 0) set.add(C * multiplier);
            multiplier++;

        }
        return set.size();

    }
}
