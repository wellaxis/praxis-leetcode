package com.witalis.praxis.leetcode.task.h2.p180.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 180
 * Name: Consecutive Numbers
 * URL: <a href="https://leetcode.com/problems/consecutive-numbers/">Consecutive Numbers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return consecutiveNumbers();
    }

    public String consecutiveNumbers() {
        return
            """

            SELECT DISTINCT l1.Num AS "ConsecutiveNums"
            FROM   Logs l1,
                   Logs l2,
                   Logs l3
            WHERE  l1.Id = l2.Id - 1
            AND    l2.Id = l3.Id - 1
            AND    l1.Num = l2.Num
            AND    l2.Num = l3.Num

            """;
    }
}
