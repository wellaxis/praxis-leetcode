package com.witalis.praxis.leetcode.task.h10.p904;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p904.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 904,
    description = "Fruit Into Baskets",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, SLIDING_WINDOW}
)
public class FruitIntoBaskets extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int[] fruits;

    public static final String INFORMATION = """

        Description:
            You are visiting a farm that has a single row of fruit trees arranged from left to right.
                The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

            You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
                * You only have two baskets, and each basket can only hold a single type of fruit.
                  There is no limit on the amount of fruit each basket can hold.
                * Starting from any tree of your choice, you must pick exactly one fruit from every tree
                  including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
                * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

            Given the integer array fruits, return the maximum number of fruits you can pick.

        Example:
            Input: fruits = [1,2,3,2,2]
            Output: 4
            Explanation: We can pick from trees [2,3,2,2].
                If we had started at the first tree, we would only pick from trees [1,2].""";

    public FruitIntoBaskets(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.fruits = random.ints(len, 0, len).toArray();

        log.info("Fruits: {}", Arrays.toString(fruits));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5744 ms
    @Override
    protected Integer original() {
        var original = new Original(fruits);
        return original.process();
    }

    // time = 3630 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(fruits);
        return practice.process();
    }

    // time = 29404 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(fruits);
        return solution.process();
    }
}
