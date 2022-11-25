package com.witalis.praxis.leetcode.task.h4.p347.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ID: 347
 * Name: Top K Frequent Elements
 * URL: <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int quantity;

    public int[] process() {
        return topKFrequent(numbers, quantity);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
