package com.witalis.praxis.leetcode.task.h7.p673.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 673
 * Name: Number of Longest Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/">Number of Longest Increasing Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findNumberOfLIS(numbers);
    }

    public int findNumberOfLIS(int[] nums) {
        int num = nums.length;
        List<int[]>[] len = new ArrayList[num];
        for (int i = 0; i < num; i++) {
            len[i] = new ArrayList<>();
        }

        int size = 0;
        for (int n : nums) {
            int index = binarySearchLength(len, size, n);
            int count = 1;

            if (index > 0) {
                List<int[]> t = len[index - 1];
                int p = binarySearchIndex(t, n);
                count = t.get(t.size() - 1)[1] - (p == 0 ? 0 : t.get(p - 1)[1]);
            }
            if (len[index].size() == 0) {
                len[index].add(new int[]{n, count});
                size++;
            } else {
                List<int[]> t = len[index];
                int[] last = t.get(t.size() - 1);

                if (last[0] == n) {
                    last[1] += count;
                } else {
                    t.add(new int[]{n, last[1] + count});
                }
            }
        }

        return len[size - 1].get(len[size - 1].size() - 1)[1];
    }

    public int binarySearchLength(List<int[]>[] len, int right, int n) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (n > len[mid].get(len[mid].size() - 1)[0])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int binarySearchIndex(List<int[]> t, int num) {
        int left = 0;
        int right = t.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num <= t.get(mid)[0])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
