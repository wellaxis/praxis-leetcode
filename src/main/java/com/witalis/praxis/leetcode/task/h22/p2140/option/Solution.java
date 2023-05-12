package com.witalis.praxis.leetcode.task.h22.p2140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2140
 * Name: Solving Questions With Brainpower
 * URL: <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">Solving Questions With Brainpower</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] questions;

    public Long process() {
        return mostPoints(questions);
    }

    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        final long[] maxPoints = new long[n + 1];

        long position;
        for (int index = questions.length - 1; index >= 0; index--) {
            int left = questions[index][1];
            int right = index + left + 1;

            if (right <= questions.length) {
                position = questions[index][0] + maxPoints[right];
            } else {
                position = questions[index][0];
            }

            maxPoints[index] = Math.max(maxPoints[index + 1], position);
        }

        return maxPoints[0];
    }
}
