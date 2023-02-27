package com.witalis.praxis.leetcode.task.h4.p368.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 368
 * Name: Largest Divisible Subset
 * URL: <a href="https://leetcode.com/problems/largest-divisible-subset/">Largest Divisible Subset</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<Integer> process() {
        return largestDivisibleSubset(numbers);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        if (n == 0) return new ArrayList<>();

        int max = 0;
        Arrays.sort(nums);
        ArrayList<Integer> ls = new ArrayList<>();
        int[] current = new int[n];
        int[] previous = new int[n];

        Arrays.fill(previous, -1);
        for (int i = 0; nums[i] <= nums[n - 1] / 2; ++i) {
            for (int j = i + 1, f = 2; nums[i] <= nums[n - 1] / f; f = (nums[j] + nums[i] - 1) / nums[i]) {
                int id = Arrays.binarySearch(nums, j, n, f * nums[i]);
                if (id > 0 && current[id] <= current[i]) {
                    previous[id] = i;
                    current[id] = current[i] + 1;
                    if (current[id] > current[max])
                        max = id;
                }
                j = id >= 0 ? id + 1 : -(id + 1);
                if (j >= n) break;
            }
        }

        for (int i = max; i >= 0; i = previous[i]) ls.add(0, nums[i]);

        return ls;
    }
}
