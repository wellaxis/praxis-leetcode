package com.witalis.praxis.leetcode.task.h5.p448.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 448
 * Name: Find All Numbers Disappeared in an Array
 * URL: <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Find All Numbers Disappeared in an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<Integer> process() {
        return findDisappearedNumbers(numbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> list = new ArrayList<>(IntStream.rangeClosed(1, nums.length).boxed().toList());
        list.removeAll(Arrays.stream(nums).boxed().toList());

        return list;
    }
}
