package com.witalis.praxis.leetcode.task.h17.p1626.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1626
 * Name: Best Team With No Conflicts
 * URL: <a href="https://leetcode.com/problems/best-team-with-no-conflicts/">Best Team With No Conflicts</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] scores;
    private int[] ages;

    public Integer process() {
        return bestTeamScore(scores, ages);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        return 0;
    }
}
