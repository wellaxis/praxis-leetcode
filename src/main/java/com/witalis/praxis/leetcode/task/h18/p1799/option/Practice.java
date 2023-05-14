package com.witalis.praxis.leetcode.task.h18.p1799.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1799
 * Name: Maximize Score After N Operations
 * URL: <a href="https://leetcode.com/problems/maximize-score-after-n-operations/">Maximize Score After N Operations</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Practice(int[] numbers) {
        this.numbers = numbers;
    }

    public Integer process() {
        return maxScore(numbers);
    }

    private Map<Integer, Integer> cache;

    public int maxScore(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;
        final boolean[] seen = new boolean[n];
        this.cache = new HashMap<>();

        return dfs(nums, seen, 1);
    }

    private int dfs(int[] nums, boolean[] seen, int index) {
        if (cache.containsKey(seenHash(seen))) return cache.get(seenHash(seen));

        final int n = nums.length;

        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            if (seen[i]) continue;

            seen[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (seen[j]) continue;

                seen[j] = true;

                int currScore = index * gcd(nums[i], nums[j]);
                int nextMaxScore = dfs(nums, seen, index + 1);
                int totalScore = currScore + nextMaxScore;
                maxScore = Math.max(maxScore, totalScore);

                seen[j] = false;
            }
            seen[i] = false;
        }
        cache.put(seenHash(seen), maxScore);

        return maxScore;
    }

    // greatest common divisor
    private static int gcd(int x, int y) {
        int tmp;
        while (0 != y) {
            tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }

    // boolean array hashing
    private static int seenHash(boolean[] array){
        int n = 0;
        for (boolean b : array)
            n = (n << 1) | (b ? 1 : 0);

        return n;
    }
}
