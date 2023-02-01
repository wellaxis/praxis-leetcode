package com.witalis.praxis.leetcode.task.h17.p1626.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

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

    record Player(int age, int score) {}

    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores == null || ages == null || scores.length != ages.length) return 0;

        final int n = scores.length;
        final int[] dp = new int[n];

        final Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(ages[i], scores[i]);
        }
        Arrays.sort(players, Comparator.comparing(Player::score).thenComparing(Player::age));

        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = players[i].score();
            for (int j = 0; j < i; j++) {
                if (players[j].age() <= players[i].age()) {
                    dp[i] = Math.max(dp[i], players[i].score() + dp[j]);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }

        return maxScore;
    }
}
