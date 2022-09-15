package com.witalis.praxis.leetcode.task.h3.p229.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * ID: 229
 * Name: Majority Element II
 * URL: <a href="https://leetcode.com/problems/majority-element-ii/">Majority Element II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<Integer> process() {
        return majorityElement(numbers);
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> elements = new ArrayList<>();

        final int frequency = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        map.forEach((key, value) -> {
            if (value > frequency) elements.add(key);
        });

        return elements;
    }

    public List<Integer> majorityElementStream(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> elements = new ArrayList<>();

        final int frequency = nums.length / 3;
        Arrays.stream(nums)
            .boxed()
            .collect(groupingBy(Function.identity(), counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() > frequency)
            .forEach(entry -> elements.add(entry.getKey()));

        return elements;
    }
}
