package com.witalis.praxis.leetcode.task.h22.p2103;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2103.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2103,
    description = "Rings and Rods",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING}
)
public class RingsAndRods extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private String rings;

    public static final String INFORMATION = """

        Description:
            There are n rings and each ring is either red, green, or blue.
                The rings are distributed across ten rods labeled from 0 to 9.

            You are given a string rings of length 2n that describes the n rings
                that are placed onto the rods. Every two characters in rings forms
                a color-position pair that is used to describe each ring where:
                * The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
                * The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').

            For example, "R3G2B1" describes n == 3 rings:
                a red ring placed onto the rod labeled 3,
                a green ring placed onto the rod labeled 2,
                and a blue ring placed onto the rod labeled 1.

            Return the number of rods that have all three colors of rings on them.

        Example:
            Input: rings = "B0B6G0R6R0R6G9"
            Output: 1
            Explanation:
                - The rod labeled 0 holds 3 rings with all colors: red, green, and blue.
                - The rod labeled 6 holds 3 rings, but it only has red and blue.
                - The rod labeled 9 holds only a green ring.
                Thus, the number of rods with all three colors is 1.""";

    public RingsAndRods(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char color = switch (random.nextInt(0, 3)) {
                case 0 -> 'R';
                case 1 -> 'G';
                case 2 -> 'B';
                default -> throw new IllegalStateException("Unexpected color");
            };
            int rod = random.nextInt(0, 10);
            builder.append(color).append(rod);
        }
        this.rings = builder.toString();

        log.info("Rings: '{}'", rings);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1744 ms
    @Override
    protected Integer original() {
        var original = new Original(rings);
        return original.process();
    }

    // time = 506 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(rings);
        return practice.process();
    }

    // time = 687 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(rings);
        return solution.process();
    }
}
