package com.witalis.praxis.leetcode.task.h23.p2244.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2244
 * Name: Minimum Rounds to Complete All Tasks
 * URL: <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">Minimum Rounds to Complete All Tasks</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] tasks;

    public Integer process() {
        return minimumRounds(tasks);
    }

    public int minimumRounds(int[] tasks) {
        if (tasks == null) return -1;
        if (tasks.length == 0) return 0;

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int task : tasks) {
            frequencies.put(task, frequencies.getOrDefault(task, 0) + 1);
        }

        int rounds = 0;
        for (final Map.Entry<Integer, Integer> frequency : frequencies.entrySet()) {
            final int task = frequency.getKey();
            final int count = frequency.getValue();

            if (count == 1) return -1;
            rounds += count / 3 + ((count % 3 == 0) ? 0 : 1);
        }

        return rounds;
    }
}
