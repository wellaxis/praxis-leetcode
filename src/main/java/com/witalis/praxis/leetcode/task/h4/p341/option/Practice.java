package com.witalis.praxis.leetcode.task.h4.p341.option;

import com.witalis.praxis.leetcode.task.h4.p341.content.NestedInteger;
import com.witalis.praxis.leetcode.task.h4.p341.content.NestedIteratorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * ID: 341
 * Name: Flatten Nested List Iterator
 * URL: <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<NestedInteger> nestedIntegers;

    public class NestedIterator implements Iterator<Integer> {
        private final Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.queue = marshall(nestedList);
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private static Queue<Integer> marshall(List<NestedInteger> nestedList) {
            Queue<Integer> queue = new ArrayDeque<>();

            for (NestedInteger nestedInteger: nestedList) {
                if (nestedInteger.isInteger()) {
                    queue.offer(nestedInteger.getInteger());
                } else {
                    List<NestedInteger> list = nestedInteger.getList();
                    queue.addAll(marshall(list));
                }
            }

            return queue;
        }
    }

    public List<String> process() {
        return NestedIteratorHandler.process(new NestedIterator(nestedIntegers));
    }
}
