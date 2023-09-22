package com.witalis.praxis.leetcode.task.h4.p384.option;

import com.witalis.praxis.leetcode.task.h4.p384.content.RandomizableArray;
import com.witalis.praxis.leetcode.task.h4.p384.content.RandomizedArrayHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 384
 * Name: Shuffle an Array
 * URL: <a href="https://leetcode.com/problems/shuffle-an-array/">Shuffle an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class RandomizedArray implements RandomizableArray {
        private final int[] numbers;
        private final List<Integer> numbersList;

        public RandomizedArray(int[] nums) {
            this.numbers = nums;
            this.numbersList = new ArrayList<>(Arrays.stream(numbers).boxed().toList());
        }

        @Override
        public int[] reset() {
            return numbers;
        }

        @Override
        public int[] shuffle() {
            Collections.shuffle(numbersList);
            return numbersList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public List<String> process() {
        final int[] numbers = operations.get(0).getValue();
        return RandomizedArrayHandler.process(operations, new RandomizedArray(numbers));
    }
}
