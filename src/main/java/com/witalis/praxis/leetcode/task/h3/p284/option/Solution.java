package com.witalis.praxis.leetcode.task.h3.p284.option;

import com.witalis.praxis.leetcode.task.h3.p284.content.PeekIterator;
import com.witalis.praxis.leetcode.task.h3.p284.content.IteratorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 284
 * Name: Peeking Iterator
 * URL: <a href="https://leetcode.com/problems/peeking-iterator/">Peeking Iterator</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Iterator<Integer>>> operations;

    public class PeekingIterator<E> implements Iterator<E>, PeekIterator<E> {
        private Iterator<E> iterator;
        private boolean hasPeeked;
        private E peekedElement;

        public PeekingIterator() {
            super();
        }

        public PeekingIterator(final Iterator<E> iterator) {
            this();
            init(iterator);
        }

        @Override
        public void init(Iterator<E> iterator) {
            this.iterator = iterator;
        }

        @Override
        public E peek() {
            if (!hasPeeked) {
                peekedElement = iterator.next();
                hasPeeked = true;
            }
            return peekedElement;
        }

        @Override
        public E next() {
            if (!hasPeeked) {
                return iterator.next();
            }
            E result = peekedElement;
            hasPeeked = false;
            peekedElement = null;
            return result;
        }

        @Override
        public boolean hasNext() {
            return hasPeeked || iterator.hasNext();
        }
    }

    public List<String> process() {
        return IteratorHandler.process(operations, new PeekingIterator<>());
    }
}
