package com.witalis.praxis.leetcode.task.h4.p365.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 365
 * Name: Water and Jug Problem
 * URL: <a href="https://leetcode.com/problems/water-and-jug-problem/">Water and Jug Problem</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int capacity1;
    private int capacity2;
    private int capacity3;

    public Boolean process() {
        return canMeasureWater(capacity1, capacity2, capacity3);
    }

    enum Operation { fill, empty, pour }

    record Capacity(int jug1, int jug2) {}

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity < 0 || jug2Capacity < 0) return false;
        if (targetCapacity == 0) return true;

        final Queue<Capacity> queue = new ArrayDeque<>();
        final Set<Capacity> cache = new HashSet<>();

        Capacity capacity = new Capacity(0, 0);
        queue.offer(capacity);
        cache.add(capacity);

        Capacity candidate;
        while (!queue.isEmpty()) {
            capacity = queue.poll();
            // checks
            if (capacity.jug1 == targetCapacity || capacity.jug2 == targetCapacity) return true;
            if (capacity.jug1 + capacity.jug2 == targetCapacity) return true;
            if (Math.abs(capacity.jug1 - capacity.jug2) == targetCapacity) return true;
            // operations
            for (Operation operation : Operation.values()) {
                switch (operation) {
                    case fill -> {
                        // 1st
                        candidate = new Capacity(jug1Capacity, capacity.jug2);
                        if (!cache.contains(candidate)) {
                            queue.offer(candidate);
                            cache.add(candidate);
                        }
                        // 2nd
                        candidate = new Capacity(capacity.jug1, jug2Capacity);
                        if (!cache.contains(candidate)) {
                            queue.offer(candidate);
                            cache.add(candidate);
                        }
                    }
                    case empty -> {
                        // 1st
                        candidate = new Capacity(0, capacity.jug2);
                        if (!cache.contains(candidate)) {
                            queue.offer(candidate);
                            cache.add(candidate);
                        }
                        // 2nd
                        candidate = new Capacity(capacity.jug1, 0);
                        if (!cache.contains(candidate)) {
                            queue.offer(candidate);
                            cache.add(candidate);
                        }
                    }
                    case pour -> {
                        // 1st
                        int pour1 = Math.min(capacity.jug1, jug2Capacity - capacity.jug2);
                        if (pour1 > 0) {
                            candidate = new Capacity(capacity.jug1 - pour1, capacity.jug2 + pour1);
                            if (!cache.contains(candidate)) {
                                queue.offer(candidate);
                                cache.add(candidate);
                            }
                        }
                        // 2nd
                        int pour2 = Math.min(capacity.jug2, jug1Capacity - capacity.jug1);
                        if (pour2 > 0) {
                            candidate = new Capacity(capacity.jug1 + pour2, capacity.jug2 - pour2);
                            if (!cache.contains(candidate)) {
                                queue.offer(candidate);
                                cache.add(candidate);
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
