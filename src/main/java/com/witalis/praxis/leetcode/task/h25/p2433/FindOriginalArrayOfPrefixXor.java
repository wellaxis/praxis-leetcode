package com.witalis.praxis.leetcode.task.h25.p2433;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2433.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2433,
    description = "Find The Original Array of Prefix Xor",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BIT_MANIPULATION}
)
public class FindOriginalArrayOfPrefixXor extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
                * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].

            Note that ^ denotes the bitwise-xor operation.

            It can be proven that the answer is unique.

        Example:
            Input: pref = [5,2,0,3,1]
            Output: [5,7,2,3,2]
            Explanation: From the array [5,7,2,3,2] we have the following:
                - pref[0] = 5.
                - pref[1] = 5 ^ 7 = 2.
                - pref[2] = 5 ^ 7 ^ 2 = 0.
                - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
                - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.""";

    public FindOriginalArrayOfPrefixXor(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1249 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1232 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1200 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
