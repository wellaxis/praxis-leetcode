package com.witalis.praxis.leetcode.task.h8.p735.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 735
 * Name: Asteroid Collision
 * URL: <a href="https://leetcode.com/problems/asteroid-collision/">Asteroid Collision</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] asteroids;

    public int[] process() {
        return asteroidCollision(asteroids);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int top = -1;
        for (int asteroid : asteroids) {
            boolean stillAlive = true;
            while (stillAlive && asteroid < 0 && top >= 0 && asteroids[top] > 0) {
                stillAlive = asteroids[top] + asteroid < 0;
                if (asteroids[top] + asteroid <= 0) top--;
            }
            if (stillAlive) asteroids[++top] = asteroid;
        }

        return Arrays.copyOf(asteroids, top + 1);
    }
}
