package com.witalis.praxis.leetcode.task.h4.p398.option;

import com.witalis.praxis.leetcode.task.h4.p398.content.RandomPick;
import com.witalis.praxis.leetcode.task.h4.p398.content.RandomPickHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ID: 398
 * Name: Random Pick Index
 * URL: <a href="https://leetcode.com/problems/random-pick-index/">Random Pick Index</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class RandomSolution implements RandomPick {
        private static final Random RANDOM = ThreadLocalRandom.current();
        private final Map<Integer, List<Integer>> statistics;

        public RandomSolution(int[] nums) {
            this.statistics = new HashMap<>();

            final int n = nums.length;
            for (int i = 0; i < n; i++) {
                statistics.putIfAbsent(nums[i], new ArrayList<>());
                statistics.get(nums[i]).add(i);
            }
        }

        @Override
        public int pick(int target) {
            List<Integer> indices = statistics.get(target);
            return indices.get(RANDOM.nextInt(0, indices.size()));
        }
    }

    public List<Integer> process() {
        var solution = new RandomSolution(operations.get(0).getValue());
        return RandomPickHandler.process(operations, solution);
    }
}
