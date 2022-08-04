package com.witalis.praxis.leetcode.task.h2.p178.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 178
 * Name: Rank Scores
 * URL: <a href="https://leetcode.com/problems/rank-scores/">Rank Scores</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return rankScores();
    }

    public String rankScores() {
        return
            """

            SELECT s.score AS "score",
                   DENSE_RANK() OVER(ORDER BY s.score DESC) AS "rank"
            FROM   scores s

            """;
    }
}
