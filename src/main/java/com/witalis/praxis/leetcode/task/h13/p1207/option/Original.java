package com.witalis.praxis.leetcode.task.h13.p1207.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * ID: 1207
 * Name: Unique Number of Occurrences
 * URL: <a href="https://leetcode.com/problems/unique-number-of-occurrences/">Unique Number of Occurrences</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return uniqueOccurrences(numbers);
    }

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        List<Long> data = Arrays.stream(arr)
            .boxed()
            .collect(groupingBy(Function.identity(), counting()))
            .values()
            .stream().toList();

        return data.size() == data.stream().distinct().count();
    }
}
