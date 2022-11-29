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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class RandomizedSet implements RandomizableSet<Integer> {
        private static final Random random = ThreadLocalRandom.current();
        private final List<Integer> list;
        private final Set<Integer> set;

        public RandomizedSet() {
            this.list = new ArrayList<>();
            this.set = new HashSet<>();
        }

        @Override
        public boolean insert(Integer val) {
            if (set.contains(val)) return false;
            list.add(val);
            return set.add(val);
        }

        @Override
        public boolean remove(Integer val) {
            if (!set.contains(val)) return false;
            list.remove(val);
            return set.remove(val);
        }

        @Override
        public Integer getRandom() {
            return list.get(random.nextInt(0, list.size()));
        }
    }

    public List<String> process() {
        return RandomizedSetHandler.process(operations, new RandomizedSet());
    }
}
