package com.witalis.praxis.leetcode.task.h7.p619.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 619
 * Name: Biggest Single Number
 * URL: <a href="https://leetcode.com/problems/biggest-single-number/">Biggest Single Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return biggestSingleNumber();
    }

    public String biggestSingleNumber() {
        return
            """

            SELECT MAX(num) AS num
            FROM (
                SELECT num,
                       COUNT(*) OVER(PARTITION BY num) AS count
                FROM   MyNumbers
            )
            WHERE  count = 1

            """;
    }
}
