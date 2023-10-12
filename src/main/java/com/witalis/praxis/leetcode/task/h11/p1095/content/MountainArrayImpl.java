package com.witalis.praxis.leetcode.task.h11.p1095.content;

import java.util.Arrays;

/**
 * Desc: Mountain array class.
 * User: Wellaxis
 * Date: 10/12/2023
 */
public class MountainArrayImpl implements MountainArray {
    private final int[] array;

    public MountainArrayImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        if (index > array.length) return -1;

        return array[index];
    }

    @Override
    public int length() {
        if (array == null) return -1;

        return array.length;
    }

    @Override
    public String toString() {
        return "MountainArray {" + Arrays.toString(array) + '}';
    }
}
