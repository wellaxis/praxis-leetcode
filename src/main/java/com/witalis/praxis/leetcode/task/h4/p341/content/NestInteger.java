package com.witalis.praxis.leetcode.task.h4.p341.content;

import java.util.Collections;
import java.util.List;

public class NestInteger implements NestedInteger {
    private Integer integer;
    private List<NestedInteger> integers;

    public NestInteger(Integer integer) {
        this.integer = integer;
        this.integers = Collections.emptyList();
    }

    public NestInteger(List<NestedInteger> integers) {
        this.integers = integers;
        this.integer = null;
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return integers;
    }

    @Override
    public String toString() {
        return "[" + "int=" + integer + ", ints={" + integers + "}" + "]";
    }
}
