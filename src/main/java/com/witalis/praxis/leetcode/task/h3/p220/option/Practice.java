package com.witalis.praxis.leetcode.task.h3.p220.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 220
 * Name: Contains Duplicate III
 * URL: <a href="https://leetcode.com/problems/contains-duplicate-iii/">Contains Duplicate III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int indexDiff;
    private int valueDiff;

    public Boolean process() {
        return containsNearbyAlmostDuplicate(numbers, indexDiff, valueDiff);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) return false;

        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long number = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = number / ((long) t + 1);

            if (buckets.containsKey(bucket)) return true;
            if (buckets.containsKey(bucket - 1) && number - buckets.get(bucket - 1) <= t) return true;
            if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - number <= t) return true;

            if (buckets.entrySet().size() >= k) {
                long prevNumber = (long) nums[i - k] - Integer.MIN_VALUE;
                long prevBucket = prevNumber / ((long) t + 1);
                buckets.remove(prevBucket);
            }

            buckets.put(bucket, number);
        }

        return false;
    }
}
