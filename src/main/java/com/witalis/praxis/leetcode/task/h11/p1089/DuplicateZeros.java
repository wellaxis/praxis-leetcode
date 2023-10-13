package com.witalis.praxis.leetcode.task.h11.p1089;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1089.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1089,
    description = "Duplicate Zeros",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS}
)
public class DuplicateZeros extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 9;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given a fixed-length integer array arr, duplicate each occurrence of zero,
                shifting the remaining elements to the right.

            Note that elements beyond the length of the original array are not written.
                Do the above modifications to the input array in place and do not return anything.

        Example:
            Input: arr = [1,0,2,3,0,4,5,0]
            Output: [1,0,0,2,3,0,0,4]
            Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]""";

    public DuplicateZeros(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Heights: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 545 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 515 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 442 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
