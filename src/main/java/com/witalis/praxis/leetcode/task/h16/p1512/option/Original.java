package com.witalis.praxis.leetcode.task.h16.p1512.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * ID: 1512
 * Name: Number of Good Pairs
 * URL: <a href="https://leetcode.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return numIdenticalPairs(numbers);
    }

    public int numIdenticalPairs(int[] nums) {
        if (nums == null) return 0;

        return Math.toIntExact(
            Arrays.stream(nums)
            .boxed()
            .collect(groupingBy(Function.identity(), counting()))
            .values().stream()
            .filter(quantity -> quantity > 1L)
            .reduce(0L, (count, pairs) -> count + goodPairs(pairs))
        );
    }

    private static long goodPairs(long pairs) {
        return (pairs * (pairs - 1)) / 2;
    }
}
