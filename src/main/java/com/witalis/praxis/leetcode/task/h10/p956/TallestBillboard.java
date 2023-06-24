package com.witalis.praxis.leetcode.task.h10.p956;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p956.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 956,
    description = "Tallest Billboard",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class TallestBillboard extends LeetCodeTask<Integer> {
    public static final int LEN = 20;
    public static final int VALUE = 1_000;

    private int[] rods;

    public static final String INFORMATION = """

        Description:
            You are installing a billboard and want it to have the largest height.
                The billboard will have two steel supports, one on each side. Each steel support must be an equal height.

            You are given a collection of rods that can be welded together.
                For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.

            Return the largest possible height of your billboard installation.
                If you cannot support the billboard, return 0.

        Example:
            Input: rods = [1,2,3,4,5,6]
            Output: 10
            Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.""";

    public TallestBillboard(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.rods = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Rods: {}", Arrays.toString(rods));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 97658 ms
    @Override
    protected Integer original() {
        var original = new Original(rods.clone());
        return original.process();
    }

    // time = 84852 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(rods.clone());
        return practice.process();
    }

    // time = 158581 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(rods.clone());
        return solution.process();
    }
}
