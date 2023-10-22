package com.witalis.praxis.leetcode.task.h15.p1425.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * ID: 1425
 * Name: Constrained Subsequence Sum
 * URL: <a href="https://leetcode.com/problems/constrained-subsequence-sum/">Constrained Subsequence Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int gap;

    public Integer process() {
        return constrainedSubsetSum(numbers, gap);
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        if (nums == null || k <= 0) return 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        heap.add(new int[]{nums[0], 0});
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (i - heap.peek()[1] > k) {
                heap.remove();
            }

            int sum = Math.max(0, heap.peek()[0]) + nums[i];
            maxSum = Math.max(maxSum, sum);
            heap.add(new int[]{sum, i});
        }

        return maxSum;
    }
}
