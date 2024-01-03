package com.witalis.praxis.leetcode.task.h22.p2125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2125
 * Name: Number of Laser Beams in a Bank
 * URL: <a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank/">Number of Laser Beams in a Bank</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] bank;

    public Integer process() {
        return numberOfBeams(bank);
    }

    public int numberOfBeams(String[] bank) {
        if (bank == null) return 0;

        int totalBeams = 0;

        int previous = 0;
        for (String floor : bank) {
            int current = 0;

            int beams = 0;
            for (char cell : floor.toCharArray())
                if (cell == '1') {
                    current++;
                    beams += previous;
                }

            if (current > 0) {
                if (beams > 0) totalBeams += beams;
                previous = current;
            }
        }

        return totalBeams;
    }
}
