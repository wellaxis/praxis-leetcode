package com.witalis.praxis.leetcode.task.h2.p169.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * ID: 169
 * Name: Majority Element
 * URL: <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return majorityElement(numbers);
    }

    public int majorityElement(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(
                groupingBy(
                    Function.identity(), counting()
                )
            ).entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElseThrow()
            .getKey();
    }
}
