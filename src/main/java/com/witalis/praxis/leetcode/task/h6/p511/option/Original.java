package com.witalis.praxis.leetcode.task.h6.p511.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 511
 * Name: Game Play Analysis I
 * URL: <a href="https://leetcode.com/problems/game-play-analysis-i/">Game Play Analysis I</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return gamePlayAnalysis();
    }

    public String gamePlayAnalysis() {
        return
            """

            SELECT a.player_id AS "player_id",
                   TO_CHAR(MIN(a.event_date), 'YYYY-MM-DD') AS "first_login"
            FROM   activity a
            GROUP BY a.player_id

            """;
    }
}
