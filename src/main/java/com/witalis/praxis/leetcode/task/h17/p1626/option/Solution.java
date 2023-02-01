package com.witalis.praxis.leetcode.task.h17.p1626.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1626
 * Name: Best Team With No Conflicts
 * URL: <a href="https://leetcode.com/problems/best-team-with-no-conflicts/">Best Team With No Conflicts</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] scores;
    private int[] ages;

    public Integer process() {
        return bestTeamScore(scores, ages);
    }

    // Binary Indexed Tree (BIT) / Fenwick Tree
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = ages.length;
        int[][] ageScorePair = new int[N][2];

        for (int i = 0; i < N; i++) {
            ageScorePair[i][0] = scores[i];
            ageScorePair[i][1] = ages[i];
        }

        // sort in ascending order of score and then by age.
        Arrays.sort(ageScorePair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int highestAge = 0;
        for (int i : ages) {
            highestAge = Math.max(highestAge, i);
        }
        int[] tree = new int[highestAge + 1];

        int answer = Integer.MIN_VALUE;
        for (int[] ageScore : ageScorePair) {
            // maximum score up to this age might not have all the players of this age.
            int currentBest = ageScore[0] + queryBIT(tree, ageScore[1]);
            // update the tree with the current age and its best score.
            updateBIT(tree, ageScore[1], currentBest);

            answer = Math.max(answer, currentBest);
        }

        return answer;
    }

    // query tree to get the maximum score up to this age.
    private int queryBIT(int[] tree, int age) {
        int maxScore = Integer.MIN_VALUE;
        for (int i = age; i > 0; i -= i & (-i)) {
            maxScore = Math.max(maxScore, tree[i]);
        }
        return maxScore;
    }

    // update the maximum score for all the nodes with an age greater than the given age.
    private void updateBIT(int[] tree, int age, int currentBest) {
        for (int i = age; i < tree.length; i += i & (-i)) {
            tree[i] = Math.max(tree[i], currentBest);
        }
    }
}
