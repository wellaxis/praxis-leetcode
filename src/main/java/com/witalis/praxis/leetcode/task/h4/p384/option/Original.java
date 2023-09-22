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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class RandomizedArray implements RandomizableArray {
        private final int[] numbers;

        public RandomizedArray(int[] nums) {
            this.numbers = nums;
        }

        @Override
        public int[] reset() {
            return numbers;
        }

        @Override
        public int[] shuffle() {
            List<Integer> numbersList = new ArrayList<>(Arrays.stream(numbers).boxed().toList());
            Collections.shuffle(numbersList);
            return numbersList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public List<String> process() {
        final int[] numbers = operations.get(0).getValue();
        return RandomizedArrayHandler.process(operations, new RandomizedArray(numbers));
    }
}
