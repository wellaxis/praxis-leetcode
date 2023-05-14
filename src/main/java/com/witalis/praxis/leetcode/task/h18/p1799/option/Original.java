package com.witalis.praxis.leetcode.task.h18.p1799.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * ID: 1799
 * Name: Maximize Score After N Operations
 * URL: <a href="https://leetcode.com/problems/maximize-score-after-n-operations/">Maximize Score After N Operations</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maxScore(numbers);
    }

    public int maxScore(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;
        final boolean[] seen = new boolean[n];

        return dfs(nums, seen, 1);
    }

    private int dfs(int[] nums, boolean[] seen, int index) {
        final int n = nums.length;

        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            if (seen[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (seen[j]) continue;

                seen[i] = true;
                seen[j] = true;

                int currScore = index * gcd(nums[i], nums[j]);
                int nextMaxScore = dfs(nums, seen, index + 1);
                int totalScore = currScore + nextMaxScore;
                maxScore = Math.max(maxScore, totalScore);

                seen[i] = false;
                seen[j] = false;
            }
        }

        return maxScore;
    }

    // greatest common divisor
    private static int gcd(int x, int y) {
        return BigInteger.valueOf(x).gcd(BigInteger.valueOf((y))).intValue();
    }
}
