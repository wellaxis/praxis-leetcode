package com.witalis.praxis.leetcode.task.h7.p619.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 619
 * Name: Biggest Single Number
 * URL: <a href="https://leetcode.com/problems/biggest-single-number/">Biggest Single Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return biggestSingleNumber();
    }

    public String biggestSingleNumber() {
        return
            """

            SELECT MAX(n.num) AS num
            FROM (
                SELECT n.num
                FROM   MyNumbers n
                GROUP BY n.num
                HAVING COUNT(n.num) = 1
            ) n

            """;
    }
}
