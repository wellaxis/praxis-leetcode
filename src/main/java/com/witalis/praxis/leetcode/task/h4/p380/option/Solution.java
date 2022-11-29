package com.witalis.praxis.leetcode.task.h4.p380.option;

import com.witalis.praxis.leetcode.task.h4.p380.content.RandomizableSet;
import com.witalis.praxis.leetcode.task.h4.p380.content.RandomizedSetHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 380
 * Name: Insert Delete GetRandom O(1)
 * URL: <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">Insert Delete GetRandom O(1)</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class RandomizedSet implements RandomizableSet<Integer> {
        private final Map<Integer, Integer> indices;
        private final List<Integer> array;

        public RandomizedSet() {
            this.indices = new HashMap<>();
            this.array = new ArrayList<>();
        }

        @Override
        public boolean insert(Integer val) {
            if (indices.containsKey(val)) return false;

            indices.put(val, array.size());
            array.add(val);

            return true;
        }

        @Override
        public boolean remove(Integer val) {
            if (!indices.containsKey(val)) return false;

            int targetIdx = indices.get(val);
            int affectedValue = array.get(array.size() - 1);

            Collections.swap(array, targetIdx, array.size() - 1);

            indices.put(affectedValue, targetIdx);

            indices.remove(val);
            array.remove(array.size() - 1);

            return true;
        }

        @Override
        public Integer getRandom() {
            int randomIndex = (int) (Math.random() * array.size());

            return array.get(randomIndex);
        }
    }

    public List<String> process() {
        return RandomizedSetHandler.process(operations, new RandomizedSet());
    }
}
