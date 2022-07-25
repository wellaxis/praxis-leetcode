package com.witalis.praxis.leetcode.task.h5.p496.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

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
        if (nums1 == null || nums2 == null) return new int[0];

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 == 0 || n2 == 0) return new int[0];

        int[] ans = new int[n1];

        Map<Integer, Integer> elements = new HashMap<>(n2);

        for (int i = 0; i < n2; i++) {
            int value = -1;
            int index = i;
            while (index < n2) {
                if (nums2[index] > nums2[i]) {
                    value = nums2[index];
                    break;
                }
                index++;
            }
            elements.putIfAbsent(nums2[i], value);
        }

        for (int i = 0; i < n1; i++) {
            ans[i] = elements.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
