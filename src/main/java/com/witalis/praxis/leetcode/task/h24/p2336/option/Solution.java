package com.witalis.praxis.leetcode.task.h24.p2336.option;

import com.witalis.praxis.leetcode.task.h24.p2336.content.ISmallestInfiniteSet;
import com.witalis.praxis.leetcode.task.h24.p2336.content.SmallestInfiniteSetHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * ID: 2336
 * Name: Smallest Number in Infinite Set
 * URL: <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">Smallest Number in Infinite Set</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class SmallestInfiniteSet implements ISmallestInfiniteSet {
        private final SortedSet<Integer> addedIntegers;
        private int current;

        public SmallestInfiniteSet() {
            this.addedIntegers = new TreeSet<>();
            this.current = 1;
        }

        @Override
        public int popSmallest() {
            int answer;
            if (!addedIntegers.isEmpty()) {
                answer = addedIntegers.first();
                addedIntegers.remove(answer);
            } else {
                answer = current;
                current += 1;
            }

            return answer;
        }

        @Override
        public void addBack(int num) {
            if (current <= num || addedIntegers.contains(num)) {
                return;
            }

            addedIntegers.add(num);
        }
    }

    public List<Integer> process() {
        return SmallestInfiniteSetHandler.process(operations, new SmallestInfiniteSet());
    }
}
