package com.witalis.praxis.leetcode.task.h11.p1051;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1051.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1051,
    description = "Height Checker",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING, COUNTING_SORT}
)
public class HeightChecker extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private int[] heights;

    public static final String INFORMATION = """

        Description:
            A school is trying to take an annual photo of all the students. The students are asked to stand
                in a single file line in non-decreasing order by height. Let this ordering be represented
                by the integer array expected where expected[i] is the expected height of the ith student in line.

            You are given an integer array heights representing the current order that the students are standing in.
                Each heights[i] is the height of the ith student in line (0-indexed).

            Return the number of indices where heights[i] != expected[i].

        Example:
            Input: heights = [1,1,4,2,1,3]
            Output: 3
            Explanation:
                heights:  [1,1,4,2,1,3]
                expected: [1,1,1,2,3,4]
                Indices 2, 4, and 5 do not match.""";

    public HeightChecker(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.heights = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Heights: {}", Arrays.toString(heights));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3848 ms
    @Override
    protected Integer original() {
        var original = new Original(heights.clone());
        return original.process();
    }

    // time = 1128 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(heights.clone());
        return practice.process();
    }

    // time = 1063 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(heights.clone());
        return solution.process();
    }
}
