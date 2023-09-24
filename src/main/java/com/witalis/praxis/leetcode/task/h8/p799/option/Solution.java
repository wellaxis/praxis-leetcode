package com.witalis.praxis.leetcode.task.h8.p799.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 799
 * Name: Champagne Tower
 * URL: <a href="https://leetcode.com/problems/champagne-tower/">Champagne Tower</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int poured;
    private int row;
    private int glass;

    public Double process() {
        return champagneTower(poured, row, glass);
    }

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[] cup = new double[queryRow + 2];
        cup[0] = poured;

        for (int i = 0; i < queryRow; ++i) {
            for (int j = i; j >= 0; --j) {
                double spill = (cup[j] - 1) / 2;
                if (spill > 0) {
                    cup[j] = spill;
                    cup[j + 1] += spill;
                } else {
                    cup[j] = 0;
                    cup[j + 1] += 0;
                }
            }
        }

        if (cup[queryGlass] > 1) {
            return 1;
        } else {
            return cup[queryGlass];
        }
    }
}
