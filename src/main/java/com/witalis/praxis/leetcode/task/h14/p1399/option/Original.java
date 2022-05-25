package com.witalis.praxis.leetcode.task.h14.p1399.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * ID: 1399
 * Name: Count Largest Group
 * URL: <a href="https://leetcode.com/problems/count-largest-group/">Count Largest Group</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return countLargestGroup(number);
    }

    public int countLargestGroup(int n) {
        if (n <= 0) return 0;

        Map<Integer, Integer> groups = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = sumDigits(i);
            groups.computeIfPresent(sum, (k, v) -> ++v);
            groups.putIfAbsent(sum, 1);
        }

        List<Integer> sizes = new ArrayList<>(groups.values().stream().toList());
        sizes.sort(Comparator.reverseOrder());

        int count = 0;
        int group = sizes.get(0);
        for (Integer size : sizes) {
            if (group == size) count++; else break;
        }

        return count;
    }

    public int countLargestGroupStream(int n) {
        if (n <= 0) return 0;

        return IntStream.rangeClosed(1, n)
            .map(Original::sumDigits)
            .boxed()
            .collect(groupingBy(Function.identity(), counting()))
            .values().stream()
            .sorted(reverseOrder())
            .collect(groupingBy(Function.identity(), counting()))
            .entrySet().stream()
            .min(Map.Entry.comparingByKey(reverseOrder()))
            .orElse(Map.entry(0L, 0L)).getValue().intValue();
    }

    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
