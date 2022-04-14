package com.witalis.praxis.leetcode.task.h1.p1.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1
 * Name: Two Sum
 * URL: <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] nums;
    private int target;

    public int[] process() {
        return twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (cache.containsKey(diff)) {
                return new int[] {cache.get(diff), i};
            } else {
                cache.put(num, i);
            }
        }
        return result;
    }
}
