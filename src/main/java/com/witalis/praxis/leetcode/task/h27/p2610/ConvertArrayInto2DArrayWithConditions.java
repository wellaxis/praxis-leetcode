package com.witalis.praxis.leetcode.task.h27.p2610;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h27.p2610.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2610,
    description = "Convert an Array Into a 2D Array With Conditions",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE}
)
public class ConvertArrayInto2DArrayWithConditions extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 200;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
                * The 2D array should contain only the elements of the array nums.
                * Each row in the 2D array contains distinct integers.
                * The number of rows in the 2D array should be minimal.

            Return the resulting array. If there are multiple answers, return any of them.

            Note that the 2D array can have a different number of elements on each row.

        Example:
            Input: nums = [1,3,4,1,2,3,1]
            Output: [[1,3,4,2],[1,3],[1]]
            Explanation: We can create a 2D array that contains the following rows:
                - 1,3,4,2
                - 1,3
                - 1
                All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
                It can be shown that we cannot have less than 3 rows in a valid array.""";

    public ConvertArrayInto2DArrayWithConditions(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(len, 1, len + 1).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 486 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 482 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 490 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
