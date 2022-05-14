package com.witalis.praxis.leetcode.task.h3.p284.content;

import java.util.Iterator;

/**
 * Desc: Peek iterator interface.
 * User: Wellaxis
 * Date: 5/14/2022
 */
public interface PeekIterator<E> {
    // technical to initialize peeking iterator
    void init(Iterator<E> iterator);
    // returns the next element in the iteration without advancing the iterator.
    E peek();
    // should behave the same as in the Iterator interface.
    E next();
    // should behave the same as in the Iterator interface.
    boolean hasNext();
}
