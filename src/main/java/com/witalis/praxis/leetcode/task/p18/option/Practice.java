package com.witalis.praxis.leetcode.task.p18.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 18
 * Name: 4Sum
 * URL: https://leetcode.com/problems/4sum/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public List<List<Integer>> process() {
        return fourSum(numbers, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int avg;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            avg = (target - nums[i]) / 3;
            if (nums[i + 1] > avg || nums[nums.length - 1] < avg) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int r = nums.length - 1;

                avg = (target - (nums[i] + nums[j])) / 2;
                if (nums[l] > avg || nums[r] < avg) continue;

                while (l < r) {
                    int diff = target - (nums[i] + nums[j] + nums[l] + nums[r]);

                    if (diff == 0) {
                        result.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (diff > 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
