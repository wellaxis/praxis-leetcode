package com.witalis.praxis.leetcode.task.h8.p771;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p771.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 771,
    description = "Jewels and Stones",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class JewelsAndStones extends LeetCodeTask<Integer> {
    public static final int LEN = 50;

    private String jewels;
    private String stones;

    public static final String INFORMATION = """

        Description:
            You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
                Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

            Letters are case sensitive, so "a" is considered a different type of stone from "A".

        Example:
            Input: jewels = "aA", stones = "aAAbbbb"
            Output: 3""";

    public JewelsAndStones(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        Set<Character> cache = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char letter;
            if (random.nextBoolean()) {
                letter = (char) random.nextInt('A', 'Z' + 1);
            } else {
                letter = (char) random.nextInt('a', 'z' + 1);
            }
            if (!cache.contains(letter)) {
                builder.append(letter);
                cache.add(letter);
            }
        }
        this.jewels = builder.toString();

        len = random.nextInt(1, LEN + 1);
        builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char letter;
            if (random.nextBoolean()) {
                letter = (char) random.nextInt('A', 'Z' + 1);
            } else {
                letter = (char) random.nextInt('a', 'z' + 1);
            }
            builder.append(letter);
        }
        this.stones = builder.toString();

        log.info("Jewels: {}", jewels);
        log.info("Stones: {}", stones);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 684 ms
    @Override
    protected Integer original() {
        var original = new Original(jewels, stones);
        return original.process();
    }

    // time = 627 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(jewels, stones);
        return practice.process();
    }

    // time = 534 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(jewels, stones);
        return solution.process();
    }
}
