package com.witalis.praxis.leetcode.task.h4.p347.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 347
 * Name: Top K Frequent Elements
 * URL: <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Solution {
    private int[] numbers;
    private int quantity;

    public int[] process() {
        return topKFrequent(numbers, quantity);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (min > i) min = i;
            if (i > max) max = i;
        }

        int[] frequency = new int[max - min + 1];
        for (int num : nums) {
            frequency[num - min]++;
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        int maxFrequency = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                if (buckets[frequency[i]] == null) {
                    buckets[frequency[i]] = new ArrayList<>();
                }
                buckets[frequency[i]].add(i + min);
                maxFrequency = Math.max(frequency[i], maxFrequency);
            }
        }

        int[] result = new int[k];
        for (int i = maxFrequency, index = 0; i > 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (index == k) {
                        break;
                    }
                    result[index++] = num;
                }
            }
        }

        return result;
    }
}
