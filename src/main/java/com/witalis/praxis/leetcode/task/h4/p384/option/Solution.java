package com.witalis.praxis.leetcode.task.h4.p384.option;

import com.witalis.praxis.leetcode.task.h4.p384.content.RandomizableArray;
import com.witalis.praxis.leetcode.task.h4.p384.content.RandomizedArrayHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;
import java.util.Random;

/**
 * ID: 384
 * Name: Shuffle an Array
 * URL: <a href="https://leetcode.com/problems/shuffle-an-array/">Shuffle an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    // Fisher-Yates Algorithm
    class RandomizedArray implements RandomizableArray {
        private int[] array;
        private int[] original;

        Random rand = new Random();

        public RandomizedArray(int[] nums) {
            this.array = nums;
            this.original = nums.clone();
        }

        @Override
        public int[] reset() {
            array = original;
            original = original.clone();
            return original;
        }

        @Override
        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swapAt(i, randRange(i, array.length));
            }
            return array;
        }

        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public List<String> process() {
        final int[] numbers = operations.get(0).getValue();
        return RandomizedArrayHandler.process(operations, new RandomizedArray(numbers));
    }
}
