package com.witalis.praxis.leetcode.task.h11.p1004.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 1004
 * Name: Max Consecutive Ones III
 * URL: <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">Max Consecutive Ones III</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int flips;

    public Integer process() {
        return longestOnes(numbers, flips);
    }

    public int longestOnes(int[] nums, int k) {
        if (nums == null || k < 0) return 0;

        final int n = nums.length;
        Queue<Integer> zeroes = new LinkedList<>();

        int maxOnes = -1;
        int previous = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroes.offer(i);
                if (zeroes.size() > k) {
                    maxOnes = Math.max(maxOnes, i - previous - 1);
                    previous = zeroes.poll();
                }
            }
        }
        if (maxOnes == -1) maxOnes = n;
        maxOnes = Math.max(maxOnes, n - previous - 1);

        return maxOnes;
    }
}
