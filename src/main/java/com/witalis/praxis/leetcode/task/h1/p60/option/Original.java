package com.witalis.praxis.leetcode.task.h1.p60.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 60
 * Name: Permutation Sequence
 * URL: https://leetcode.com/problems/permutation-sequence/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int position;

    public String process() {
        return getPermutation(number, position);
    }

    public String getPermutation(int n, int k) {
        if (n <= 1) return String.valueOf(n);

        int[] values = IntStream.rangeClosed(1, n).toArray();
        ThreadLocal<Integer> position = ThreadLocal.withInitial(() -> k);

        return permute(
            position,
            new ArrayList<>(),
            new ArrayList<>(Arrays.stream(values).boxed().toList())
        );
    }

    private String permute(ThreadLocal<Integer> position, List<Integer> prefix, List<Integer> suffix) {
        if (suffix.size() == 1) {
            if (position.get() == 1) {
                prefix.addAll(suffix);
                StringBuilder permutation = new StringBuilder();
                for (int integer : prefix) permutation.append(integer);
                return permutation.toString();
            }
            position.set(position.get() - 1);
        } else {
            for (int i = 0; i < suffix.size() && position.get() > 0; i++) {
                Integer number = suffix.get(i);

                List<Integer> nextPrefix = new ArrayList<>(prefix);
                nextPrefix.add(number);

                List<Integer> nextSuffix = new ArrayList<>(suffix);
                nextSuffix.remove(number);

                String permutation = permute(position, nextPrefix, nextSuffix);
                if (permutation != null) return permutation;
            }
        }
        return null;
    }
}
