package com.witalis.praxis.leetcode.task.h8.p735;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p735.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 735,
    description = "Asteroid Collision",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STACK, SIMULATION}
)
public class AsteroidCollision extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000;

    private int[] asteroids;

    public static final String INFORMATION = """

        Description:
            We are given an array asteroids of integers representing asteroids in a row.

            For each asteroid, the absolute value represents its size, and the sign represents its direction
                (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

            Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
                If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

        Example:
            Input: asteroids = [10,2,-5]
            Output: [10]
            Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.""";

    public AsteroidCollision(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.asteroids = random.ints(
                random.nextInt(2, LEN + 1),
                -VALUE, VALUE + 1
            )
            .toArray();
        for (int i = 0; i < asteroids.length; i++)
            if (asteroids[i] == 0)
                asteroids[i] = random.nextBoolean() ? 1 : -1;

        log.info("Asteroids: {}", Arrays.toString(asteroids));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2041 ms
    @Override
    protected int[] original() {
        var original = new Original(asteroids);
        return original.process();
    }

    // time = 1793 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(asteroids);
        return practice.process();
    }

    // time = 941 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(asteroids);
        return solution.process();
    }
}
