package com.witalis.praxis.leetcode.task.h25.p2483.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2483
 * Name: Minimum Penalty for a Shop
 * URL: <a href="https://leetcode.com/problems/minimum-penalty-for-a-shop/">Minimum Penalty for a Shop</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String customers;

    public Integer process() {
        return bestClosingTime(customers);
    }

    public int bestClosingTime(String customers) {
        if (customers == null) return 0;

        int y = 0;
        int n = 0;
        for (char i : customers.toCharArray()) {
            if (i == 'Y') y++;
        }

        int mn = Integer.MAX_VALUE;
        int index = 0;
        int penalty;
        for (int i = 0; i < customers.length(); i++) {
            penalty = y + n;
            if (penalty < mn) {
                mn = penalty;
                index = i;
            }
            if (customers.charAt(i) == 'Y') {
                y--;
            } else {
                n++;
            }
        }

        penalty = y + n;
        if (penalty < mn) {
            index = customers.length();
        }

        return index;
    }
}
