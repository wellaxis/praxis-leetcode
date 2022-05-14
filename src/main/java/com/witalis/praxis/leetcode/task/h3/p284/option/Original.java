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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Iterator<Integer>>> operations;

    public class PeekingIterator<E> implements Iterator<E>, PeekIterator<E> {
        private Iterator<E> iterator;
        private E next;

        public PeekingIterator() {
            super();
        }

        public PeekingIterator(Iterator<E> iterator) {
            this();
            init(iterator);
        }

        @Override
        public void init(Iterator<E> iterator) {
            this.iterator = iterator;
            next();
        }

        @Override
        public E peek() {
            return next;
        }

        @Override
        public E next() {
            E current = next;
            next = iterator.hasNext() ? iterator.next() : null;
            return current;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext() || next != null;
        }
    }

    public List<String> process() {
        return IteratorHandler.process(operations, new PeekingIterator<>());
    }
}
