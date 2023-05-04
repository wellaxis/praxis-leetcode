package com.witalis.praxis.leetcode.task.h7.p649.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 649
 * Name: Dota2 Senate
 * URL: <a href="https://leetcode.com/problems/dota2-senate/description/">Dota2 Senate</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String senate;

    public String process() {
        return predictPartyVictory(senate);
    }

    public String predictPartyVictory(String senate) {
        final char[] senates = senate.toCharArray();

        int flag = 0;
        boolean r = true;
        boolean d = true;
        while (r && d) {
            r = false;
            d = false;
            for (int i = 0; i < senates.length; i++) {
                if (senates[i] == 'R') {
                    if (flag < 0) {
                        senates[i] = 0;
                    } else {
                        r = true;
                    }
                    flag++;
                } else if (senates[i] == 'D') {
                    if (flag > 0) {
                        senates[i] = 0;
                    } else {
                        d = true;
                    }
                    flag--;
                }
            }
        }

        return r ? "Radiant" : "Dire";
    }
}
