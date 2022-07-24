package com.witalis.praxis.leetcode.task.h5.p496.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 496
 * Name: Next Greater Element I
 * URL: <a href="https://leetcode.com/problems/next-greater-element-i/">Next Greater Element I</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers1;
    private int[] numbers2;

    public int[] process() {
        return nextGreaterElement(numbers1, numbers2);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return new int[0];
    }
}
