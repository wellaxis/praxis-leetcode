package com.witalis.praxis.leetcode.task.h6.p511.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 511
 * Name: Game Play Analysis I
 * URL: <a href="https://leetcode.com/problems/game-play-analysis-i/">Game Play Analysis I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return gamePlayAnalysis();
    }

    public String gamePlayAnalysis() {
        return
            """

            SELECT player_id,
                   MIN(TO_CHAR(event_date, 'yyyy-mm-dd')) first_login
            FROM   activity
            GROUP BY player_id

            """;
    }
}
