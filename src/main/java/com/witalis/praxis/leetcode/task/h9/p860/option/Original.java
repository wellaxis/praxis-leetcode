package com.witalis.praxis.leetcode.task.h9.p860.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 860
 * Name: Lemonade Change
 * URL: <a href="https://leetcode.com/problems/lemonade-change/">Lemonade Change</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] bills;

    public Boolean process() {
        return lemonadeChange(bills);
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills == null) return false;

        int change5$ = 0;
        int change10$ = 0;
        int change20$ = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5 -> change5$++;
                case 10 -> {
                    if (change5$ == 0) return false;

                    change10$++;
                    change5$--;
                }
                case 20 -> {
                    if (change5$ == 0) return false;

                    if (change10$ > 0) {
                        change20$++;
                        change10$--;
                        change5$--;
                    } else if (change5$ > 2) {
                        change20$++;
                        change5$ -= 3;
                    } else {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }

        return true;
    }
}
