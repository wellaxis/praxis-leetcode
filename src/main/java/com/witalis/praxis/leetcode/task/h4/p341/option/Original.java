package com.witalis.praxis.leetcode.task.h4.p341.option;

import com.witalis.praxis.leetcode.task.h4.p341.content.NestedIteratorHandler;
import com.witalis.praxis.leetcode.task.h4.p341.content.NestedInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Stream;

/**
 * ID: 341
 * Name: Flatten Nested List Iterator
 * URL: <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        private static Stream<NestedInteger> flattened(NestedInteger nestedInteger) {
            return Stream.concat(
                Stream.of(nestedInteger),
                nestedInteger.getList().stream().flatMap(NestedIterator::flattened)
            );
        }

        private static Queue<Integer> marshall(List<NestedInteger> nestedList) {
            List<Integer> integers = nestedList.stream()
                .flatMap(NestedIterator::flattened)
                .map(NestedInteger::getInteger)
                .filter(Objects::nonNull)
                .toList();

            return new ArrayDeque<>(integers);
        }
    }

    public List<String> process() {
        return NestedIteratorHandler.process(new NestedIterator(nestedIntegers));
    }
}
