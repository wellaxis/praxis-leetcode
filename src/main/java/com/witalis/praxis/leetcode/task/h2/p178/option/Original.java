package com.witalis.praxis.leetcode.task.h2.p178.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 178
 * Name: Rank Scores
 * URL: <a href="https://leetcode.com/problems/rank-scores/">Rank Scores</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return rankScores();
    }

    public String rankScores() {
        return
            """

                SELECT s.score AS score,
                       us.rank AS rank
                FROM   scores s,
                       (SELECT ROWNUM AS rank,
                               us.score
                        FROM   (SELECT DISTINCT s.score
                                FROM   scores s
                                ORDER BY s.score DESC
                               ) us
                       ) us
                WHERE  s.score = us.score

                """;
    }
}
