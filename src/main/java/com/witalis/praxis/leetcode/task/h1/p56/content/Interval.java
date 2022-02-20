package com.witalis.praxis.leetcode.task.h1.p56.content;

import java.util.Objects;

/**
 * Desc: Interval class
 * User: Wellaxis
 * Date: 20.02.2022
 */
public class Interval implements Comparable<Interval> {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.compare(this.start, o.start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
