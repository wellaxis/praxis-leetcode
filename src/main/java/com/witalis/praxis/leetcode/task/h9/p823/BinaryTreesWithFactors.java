package com.witalis.praxis.leetcode.task.h9.p823;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p823.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 823,
    description = "Binary Trees With Factors",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, DYNAMIC_PROGRAMMING, SORTING}
)
public class BinaryTreesWithFactors extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = (int) 1e9;

    private int[] array;

    public static final String INFORMATION = """

        Description:
            Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

            We make a binary tree using these integers, and each number may be used for any number of times.
                Each non-leaf node's value should be equal to the product of the values of its children.

            Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.

        Example:
            Input: arr = [2,4,5,10]
            Output: 7
            Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].""";

    public BinaryTreesWithFactors(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.array = random.ints(
            random.nextInt(1, LEN + 1),
            2, VALUE + 1
        ).distinct().toArray();

        log.info("Array 'arr': {}", Arrays.toString(array));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1007 ms
    @Override
    protected Integer original() {
        var original = new Original(array.clone());
        return original.process();
    }

    // time = 944 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(array.clone());
        return practice.process();
    }

    // time = 718 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(array.clone());
        return solution.process();
    }
}
