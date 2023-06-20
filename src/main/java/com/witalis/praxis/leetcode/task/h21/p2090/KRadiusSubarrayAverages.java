package com.witalis.praxis.leetcode.task.h21.p2090;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2090.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2090,
    description = "K Radius Subarray Averages",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SLIDING_WINDOW}
)
public class KRadiusSubarrayAverages extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers;
    private int radius;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed array nums of n integers, and an integer k.

            The k-radius average for a subarray of nums centered at some index i with the radius k
                is the average of all elements in nums between the indices i - k and i + k (inclusive).
                If there are less than k elements before or after the index i, then the k-radius average is -1.

            Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.

            The average of x elements is the sum of the x elements divided by x, using integer division.
                The integer division truncates toward zero, which means losing its fractional part.

            * For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

        Example:
            Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
            Output: [-1,-1,-1,5,4,4,-1,-1,-1]
            Explanation:
                - avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
                - The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
                  Using integer division, avg[3] = 37 / 7 = 5.
                - For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
                - For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
                - avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.""";

    public KRadiusSubarrayAverages(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();
        this.radius = random.nextInt(0, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Radius 'k': {}", radius);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 757 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers, radius);
        return original.process();
    }

    // time = 766 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers, radius);
        return practice.process();
    }

    // time = 761 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers, radius);
        return solution.process();
    }
}
