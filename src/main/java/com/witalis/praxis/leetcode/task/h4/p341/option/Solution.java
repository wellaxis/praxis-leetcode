package com.witalis.praxis.leetcode.task.h4.p341.option;

import com.witalis.praxis.leetcode.task.h4.p341.content.NestedInteger;
import com.witalis.praxis.leetcode.task.h4.p341.content.NestedIteratorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 341
 * Name: Flatten Nested List Iterator
 * URL: <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<NestedInteger> nestedIntegers;

    public class NestedIterator implements Iterator<Integer> {
        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            LinkedList<Integer> result = new LinkedList<>();
            for (NestedInteger ni : nestedList) traverse(ni, result);
            this.iterator = result.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void traverse(NestedInteger node, LinkedList<Integer> list) {
            if (node.isInteger()) {
                list.add(node.getInteger());
                return;
            }
            for (NestedInteger cur : node.getList()) {
                traverse(cur, list);
            }
        }
    }

    public List<String> process() {
        return NestedIteratorHandler.process(new NestedIterator(nestedIntegers));
    }
}
