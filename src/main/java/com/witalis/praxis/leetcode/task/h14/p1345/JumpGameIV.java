package com.witalis.praxis.leetcode.task.h14.p1345;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1345.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1345,
    description = "Jump Game IV",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE, BREADTH_FIRST_SEARCH}
)
public class JumpGameIV extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = (int) 10e8;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers arr, you are initially positioned at the first index of the array.

            In one step you can jump from index i to index:
                * i + 1 where: i + 1 < arr.length.
                * i - 1 where: i - 1 >= 0.
                * j where: arr[i] == arr[j] and i != j.

            Return the minimum number of steps to reach the last index of the array.

            Notice that you can not jump outside of the array at any time.

        Example:
            Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
            Output: 3
            Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.""";

    public JumpGameIV(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 21784 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 20910 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 18274 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
