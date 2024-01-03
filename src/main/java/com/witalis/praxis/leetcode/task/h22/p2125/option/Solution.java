package com.witalis.praxis.leetcode.task.h22.p2125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2125
 * Name: Number of Laser Beams in a Bank
 * URL: <a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank/">Number of Laser Beams in a Bank</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] bank;

    public Integer process() {
        return numberOfBeams(bank);
    }

    public int numberOfBeams(String[] bank) {
        int ans = 0;

        int prev = 0;
        for (String s: bank) {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1') {
                    count++;
                }

            if (count > 0) {
                ans += prev * count;
                prev = count;
            }
        }

        return ans;
    }
}
