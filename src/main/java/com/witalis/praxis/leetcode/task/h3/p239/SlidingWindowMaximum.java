package com.witalis.praxis.leetcode.task.h3.p239;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p239.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 239,
    description = "Sliding Window Maximum",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, QUEUE, SLIDING_WINDOW, HEAP, MONOTONIC_QUEUE}
)
public class SlidingWindowMaximum extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[] numbers;
    private int window;

    public static final String INFORMATION = """

        Description:
            You are given an array of integers nums, there is a sliding window of size k
                which is moving from the very left of the array to the very right.
                You can only see the k numbers in the window. Each time the sliding window moves right by one position.

            Return the max sliding window.

        Example:
            Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
            Output: [3,3,5,5,6,7]
            Explanation:
                Window position                Max
                ---------------               -----
                [1  3  -1] -3  5  3  6  7       3
                 1 [3  -1  -3] 5  3  6  7       3
                 1  3 [-1  -3  5] 3  6  7       5
                 1  3  -1 [-3  5  3] 6  7       5
                 1  3  -1  -3 [5  3  6] 7       6
                 1  3  -1  -3  5 [3  6  7]      7 """;

    public SlidingWindowMaximum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).toArray();
        this.window = random.nextInt(1, numbers.length + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Window k: {}", window);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 25285 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers, window);
        return original.process();
    }

    // time = 24104 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers, window);
        return practice.process();
    }

    // time = 11647 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers, window);
        return solution.process();
    }
}
