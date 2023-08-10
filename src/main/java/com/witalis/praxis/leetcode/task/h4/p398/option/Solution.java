package com.witalis.praxis.leetcode.task.h4.p398.option;

import com.witalis.praxis.leetcode.task.h4.p398.content.RandomPick;
import com.witalis.praxis.leetcode.task.h4.p398.content.RandomPickHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;
import java.util.Random;

/**
 * ID: 398
 * Name: Random Pick Index
 * URL: <a href="https://leetcode.com/problems/random-pick-index/">Random Pick Index</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class RandomSolution implements RandomPick {
        private int[] nums;
        private Random rand = new Random();

        public RandomSolution(int[] nums) {
            this.nums = nums;
        }

        @Override
        public int pick(int target) {
            int ans = -1;
            int range = 0;

            for (int i = 0; i < nums.length; ++i)
                if (nums[i] == target && rand.nextInt(++range) == 0)
                    ans = i;

            return ans;
        }
    }

    public List<Integer> process() {
        var solution = new RandomSolution(operations.get(0).getValue());
        return RandomPickHandler.process(operations, solution);
    }
}
