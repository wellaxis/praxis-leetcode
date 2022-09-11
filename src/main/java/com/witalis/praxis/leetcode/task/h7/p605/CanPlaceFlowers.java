package com.witalis.praxis.leetcode.task.h7.p605;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p605.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 605,
    description = "Can Place Flowers",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY}
)
public class CanPlaceFlowers extends LeetCodeTask<Boolean> {
    public static final int LEN = 20_000;
    private int[] flowerbed;
    private int flowers;

    public static final String INFORMATION = """

        You have a long flowerbed in which some of the plots are planted, and some are not.
            However, flowers cannot be planted in adjacent plots.

        Given an integer array flowerbed containing 0's and 1's,
            where 0 means empty and 1 means not empty, and an integer n,
            return if n new flowers can be planted in the flowerbed
            without violating the no-adjacent-flowers rule.

        Example:
            Input: flowerbed = [1,0,0,0,1], n = 1
            Output: true""";

    public CanPlaceFlowers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.flowerbed = new int[len];
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 4) == 0) {
                flowerbed[i] = 1;
            } else {
                flowerbed[i] = 0;
            }
        }
        this.flowers = random.nextInt(0, len + 1);

        log.info("Flowerbed is {}", Arrays.toString(flowerbed));
        log.info("Flowers are {}", flowers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1441 ms
    @Override
    protected Boolean original() {
        var original = new Original(flowerbed, flowers);
        return original.process();
    }

    // time = 774 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(flowerbed, flowers);
        return practice.process();
    }

    // time = 1133 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(flowerbed, flowers);
        return solution.process();
    }
}
