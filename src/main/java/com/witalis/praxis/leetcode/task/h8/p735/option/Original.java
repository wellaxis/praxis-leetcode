package com.witalis.praxis.leetcode.task.h8.p735.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/**
 * ID: 735
 * Name: Asteroid Collision
 * URL: <a href="https://leetcode.com/problems/asteroid-collision/">Asteroid Collision</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] asteroids;

    public int[] process() {
        return asteroidCollision(asteroids);
    }

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) return new int[0];

        final Deque<Integer> stack = new ArrayDeque<>();

        main: for (int current : asteroids) {
            if (current > 0) {
                stack.push(current);
            } else {
                while (!stack.isEmpty()) {
                    int previous = stack.peek();
                    if (previous > 0) {
                        int collision = Integer.signum(current + previous);
                        if (collision < 0) {
                            stack.pop();
                        } else {
                            if (collision == 0) stack.pop();
                            continue main;
                        }
                    } else {
                        break;
                    }
                }
                stack.push(current);
            }
        }

        final int n = stack.size();
        final int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
