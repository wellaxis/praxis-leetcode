package com.witalis.praxis.leetcode.task.h15.p1493;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1493.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1493,
    description = "Longest Subarray of 1's After Deleting One Element",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, SLIDING_WINDOW}
)
public class LongestSubarrayOf1sAfterDeletingOneElement extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given a binary array nums, you should delete one element from it.

            Return the size of the longest non-empty subarray containing only 1's in the resulting array.
                Return 0 if there is no such subarray.

        Example:
            Input: nums = [0,1,1,1,0,1,1,0,1]
            Output: 5
            Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].""";

    public LongestSubarrayOf1sAfterDeletingOneElement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            2
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1527 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1299 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1327 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
