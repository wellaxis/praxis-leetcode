package com.witalis.praxis.leetcode.task.h24.p2389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2389
 * Name: Longest Subsequence With Limited Sum
 * URL: <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/">Longest Subsequence With Limited Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int[] queries;

    public int[] process() {
        return answerQueries(numbers, queries);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        if (nums == null || queries == null) return new int[0];

        int[] answer = new int[queries.length];

        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            final int query = queries[i];
            indices.putIfAbsent(query, new ArrayList<>());
            indices.get(query).add(i);
        }

        Arrays.sort(nums);
        Arrays.sort(queries);

        int[] stats = new int[queries.length];
        int n = 0;
        int q = 0;
        int sum = 0;
        int qty = 0;
        while (q < queries.length) {
            if (sum > queries[q] || n >= nums.length) {
                q++;
                if (q < queries.length) stats[q] = (n >= nums.length) ? qty : qty - 1;
            } else {
                sum += nums[n];
                qty++;
                n++;
                stats[q] = qty - 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            final int size = stats[i];
            indices.get(queries[i]).forEach(index -> answer[index] = size);
        }

        return answer;
    }
}
