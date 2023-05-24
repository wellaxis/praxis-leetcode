package com.witalis.praxis.leetcode.task.h26.p2542.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2542
 * Name: Maximum Subsequence Score
 * URL: <a href="https://leetcode.com/problems/maximum-subsequence-score/">Maximum Subsequence Score</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;
    private int quantity;

    public Long process() {
        return maxScore(numbers1, numbers2, quantity);
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int n = nums1.length;
        final int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int min = Integer.MAX_VALUE;
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, arr[i][1]);
            sum += arr[i][0];
            pq.add(arr[i]);
        }

        ans = Math.max(ans, sum * min);

        for (int i = k; i < n; i++) {
            if (pq.peek()[0] < arr[i][0]) {
                sum -= pq.remove()[0];
                min = Math.min(min, arr[i][1]);
                sum += arr[i][0];
                pq.add(arr[i]);
                ans = Math.max(ans, sum * min);
            }
        }

        return ans;
    }
}
