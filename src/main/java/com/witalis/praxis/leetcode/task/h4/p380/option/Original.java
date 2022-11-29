package com.witalis.praxis.leetcode.task.h4.p380.option;

import com.witalis.praxis.leetcode.task.h4.p380.content.RandomizableSet;
import com.witalis.praxis.leetcode.task.h4.p380.content.RandomizedSetHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ID: 380
 * Name: Insert Delete GetRandom O(1)
 * URL: <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">Insert Delete GetRandom O(1)</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class RandomizedSet implements RandomizableSet<Integer> {
        private static final Random random = ThreadLocalRandom.current();
        private final List<Integer> data;

        public RandomizedSet() {
            this.data = new ArrayList<>();
        }

        @Override
        public boolean insert(Integer val) {
            if (data.contains(val)) return false;
            data.add(val);
            return true;
        }

        @Override
        public boolean remove(Integer val) {
            if (!data.contains(val)) return false;
            data.remove(val);
            return true;
        }

        @Override
        public Integer getRandom() {
            return data.get(random.nextInt(0, data.size()));
        }
    }

    public List<String> process() {
        return RandomizedSetHandler.process(operations, new RandomizedSet());
    }
}
