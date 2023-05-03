package com.witalis.praxis.leetcode.task.h23.p2215.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2215
 * Name: Find the Difference of Two Arrays
 * URL: <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">Find the Difference of Two Arrays</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers1;
    private int[] numbers2;

    public List<List<Integer>> process() {
        return findDifference(numbers1, numbers2);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return Collections.emptyList();

        final Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().toList());
        final Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());

        final Iterator<Integer> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            final int number = iterator1.next();
            if (set2.contains(number)) {
                iterator1.remove();
                set2.remove(number);
            }
        }
        final Iterator<Integer> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            final int number = iterator2.next();
            if (set1.contains(number)) {
                iterator2.remove();
                set1.remove(number);
            }
        }

        return List.of(set1.stream().toList(), set2.stream().toList());
    }
}
