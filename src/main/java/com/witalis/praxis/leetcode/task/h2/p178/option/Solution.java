package com.witalis.praxis.leetcode.task.h2.p178.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 178
 * Name: Rank Scores
 * URL: <a href="https://leetcode.com/problems/rank-scores/">Rank Scores</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return rankScores();
    }

    public String rankScores() {
        return
            """

            SELECT Score AS "score",
                   DENSE_RANK() OVER(ORDER BY Score DESC) AS "rank"
            FROM   Scores

            """;
    }
}
