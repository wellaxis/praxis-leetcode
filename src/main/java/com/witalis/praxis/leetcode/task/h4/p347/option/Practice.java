package com.witalis.praxis.leetcode.task.h4.p347.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Consumer;

/**
 * ID: 347
 * Name: Top K Frequent Elements
 * URL: <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int quantity;

    public int[] process() {
        return topKFrequent(numbers, quantity);
    }

    record Data(int value, int frequency) {}

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        Comparator<Data> compareByFrequency = (o1, o2) -> Integer.compare(o2.frequency, o1.frequency);
        Queue<Data> queue = new PriorityQueue<>(compareByFrequency);
        Consumer<Map.Entry<Integer, Integer>> storeTopFrequent = entry -> queue.offer(new Data(entry.getKey(), entry.getValue()));
        map.entrySet().forEach(storeTopFrequent);

        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = Objects.requireNonNull(queue.poll()).value;
        }

        return top;
    }
}
