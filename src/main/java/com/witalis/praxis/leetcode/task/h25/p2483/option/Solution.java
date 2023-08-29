package com.witalis.praxis.leetcode.task.h25.p2483.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2483
 * Name: Minimum Penalty for a Shop
 * URL: <a href="https://leetcode.com/problems/minimum-penalty-for-a-shop/">Minimum Penalty for a Shop</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String customers;

    public Integer process() {
        return bestClosingTime(customers);
    }

    public int bestClosingTime(String customers) {
        // start with closing at hour 0 and assume the current penalty is 0
        int minPenalty = 0;
        int curPenalty = 0;
        int earliestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);

            // if status in hour i is 'Y', moving it to open hours decrement penalty by 1
            // otherwise, moving 'N' to open hours increment penalty by 1
            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }

            // update earliestHour if a smaller penalty is encountered
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }

        return earliestHour;
    }
}
