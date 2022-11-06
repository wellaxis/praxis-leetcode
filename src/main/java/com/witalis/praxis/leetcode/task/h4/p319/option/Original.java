package com.witalis.praxis.leetcode.task.h4.p319.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 319
 * Name: Bulb Switcher
 * URL: <a href="https://leetcode.com/problems/bulb-switcher/">Bulb Switcher</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return bulbSwitch(number);
    }

    public int bulbSwitch(int n) {
        if (n <= 0) return 0;

        return (int) Math.sqrt(n);
    }
}
