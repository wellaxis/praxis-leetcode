package com.witalis.praxis.leetcode.task.h6.p511.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 511
 * Name: Game Play Analysis I
 * URL: <a href="https://leetcode.com/problems/game-play-analysis-i/">Game Play Analysis I</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return gamePlayAnalysis();
    }

    public String gamePlayAnalysis() {
        return
            """

            SELECT DISTINCT
                   a.player_id AS "player_id",
                   TO_CHAR(FIRST_VALUE(a.event_date) OVER(PARTITION BY a.player_id ORDER BY a.event_date ASC), 'YYYY-MM-DD') AS "first_login"
            FROM   activity a

            """;
    }
}
