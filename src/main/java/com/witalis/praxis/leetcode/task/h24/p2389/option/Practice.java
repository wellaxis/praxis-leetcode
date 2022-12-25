package com.witalis.praxis.leetcode.task.h24.p2389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2389
 * Name: Longest Subsequence With Limited Sum
 * URL: <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/">Longest Subsequence With Limited Sum</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int[] queries;

    public int[] process() {
        return answerQueries(numbers, queries);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        if (nums == null || queries == null) return new int[0];

        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        int[] answer = new int[queries.length];

        Arrays.sort(nums);
        Arrays.sort(sortedQueries);

        Map<Integer, Integer> indices = new HashMap<>();

        int sum = 0;
        int index = 0;
        for (int sortedQuery : sortedQueries) {
            while (index < nums.length && sum + nums[index] <= sortedQuery) {
                sum += nums[index];
                index++;
            }

            indices.put(sortedQuery, index);
        }

        for (int i = 0; i < queries.length; i++) {
            Integer maxSize = indices.get(queries[i]);
            if (maxSize == null) maxSize = 0;
            answer[i] = maxSize;
        }

        return answer;
    }
}
