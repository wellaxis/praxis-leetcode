package com.witalis.praxis.leetcode.task.h12.p1187;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1187.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1187,
    description = "Make Array Strictly Increasing",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, DYNAMIC_PROGRAMMING, SORTING}
)
public class MakeArrayStrictlyIncreasing extends LeetCodeTask<Integer> {
    public static final int LEN = 2_000;
    public static final int VALUE = 1_000_000_000;

    private int[] array1;
    private int[] array2;

    public static final String INFORMATION = """

        Description:
            Given two integer arrays arr1 and arr2,
                return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

            In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length
                and do the assignment arr1[i] = arr2[j].

            If there is no way to make arr1 strictly increasing, return -1.

        Example:
            Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
            Output: 2
            Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].""";

    public MakeArrayStrictlyIncreasing(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.array1 = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();
        this.array2 = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Array #1: {}", Arrays.toString(array1));
        log.info("Array #2: {}", Arrays.toString(array2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9579 ms
    @Override
    protected Integer original() {
        var original = new Original(array1.clone(), array2.clone());
        return original.process();
    }

    // time = 5671 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(array1.clone(), array2.clone());
        return practice.process();
    }

    // time = 3539 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(array1.clone(), array2.clone());
        return solution.process();
    }
}
