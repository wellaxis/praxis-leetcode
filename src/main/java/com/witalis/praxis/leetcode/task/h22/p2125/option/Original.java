package com.witalis.praxis.leetcode.task.h22.p2125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2125
 * Name: Number of Laser Beams in a Bank
 * URL: <a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank/">Number of Laser Beams in a Bank</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] bank;

    public Integer process() {
        return numberOfBeams(bank);
    }

    public int numberOfBeams(String[] bank) {
        if (bank == null) return 0;

        final int m = bank.length;
        final int n = bank[0].length();

        int totalBeams = 0;

        int previous = 0;
        for (String floor : bank) {
            int current = 0;

            int beams = 0;
            for (int i = 0; i < n; i++) {
                if (floor.charAt(i) == '1') {
                    current++;
                    beams += previous;
                }
            }
            if (current > 0) {
                if (beams > 0) {
                    totalBeams += beams;
                }
                previous = current;
            }
        }

        return totalBeams;
    }
}
