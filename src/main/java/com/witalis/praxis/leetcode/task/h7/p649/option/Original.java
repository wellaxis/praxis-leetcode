package com.witalis.praxis.leetcode.task.h7.p649.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 649
 * Name: Dota2 Senate
 * URL: <a href="https://leetcode.com/problems/dota2-senate/description/">Dota2 Senate</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
                if (senator == 'R') {
                    int dire = i + 1;
                    while (dire < n && senators[dire] != 'D') dire++;
                    if (dire == n) {
                        dire = 0;
                        while (dire < n && senators[dire] != 'D') dire++;
                        if (dire == n) return "Radiant";
                    }
                    if (dire < n) {
                        senators[dire] = '.';
                    }
                }
                if (senator == 'D') {
                    int radiant = i + 1;
                    while (radiant < n && senators[radiant] != 'R') radiant++;
                    if (radiant == n) {
                        radiant = 0;
                        while (radiant < n && senators[radiant] != 'R') radiant++;
                        if (radiant == n) return "Dire";
                    }
                    if (radiant < n) {
                        senators[radiant] = '.';
                    }
                }
            }

            final var builder = new StringBuilder();
            for (final char senator : senators) {
                if (senator != '.') builder.append(senator);
            }
            senate = builder.toString();
        }

        return "";
    }
}
