package com.witalis.praxis.leetcode.task.h7.p649.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 649
 * Name: Dota2 Senate
 * URL: <a href="https://leetcode.com/problems/dota2-senate/description/">Dota2 Senate</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String senate;

    public String process() {
        return predictPartyVictory(senate);
    }

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty()) return "";

        while (senate.length() > 0) {
            final int n = senate.length();
            final char[] senators = senate.toCharArray();

            for (int i = 0; i < n; i++) {
                final char senator = senators[i];

                if (senator == '.') continue;

                int index = i + 1;
                char ban = senator == 'R' ? 'D' : 'R';
                while (index < n && senators[index] != ban) index++;
                if (index == n) {
                    index = 0;
                    while (index < i && senators[index] != ban) index++;
                    if (index == i) return senator == 'R' ? "Radiant" : "Dire";
                }
                if (index < n) {
                    senators[index] = '.';
                }
            }

            senate = new String(senators).replace("\\.", "");
        }

        return "";
    }
}
