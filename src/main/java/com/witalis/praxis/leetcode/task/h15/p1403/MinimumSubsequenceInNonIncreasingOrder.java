package com.witalis.praxis.leetcode.task.h15.p1403;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1403.option.*;
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
    id = 1403,
    description = "Minimum Subsequence in Non-Increasing Order",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY, SORTING}
)
public class MinimumSubsequenceInNonIncreasingOrder extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 500;
    public static final int VALUE = 100;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given the array nums, obtain a subsequence of the array whose sum of elements
                is strictly greater than the sum of the non included elements in such subsequence.

            If there are multiple solutions, return the subsequence with minimum size and if there still exist
                multiple solutions, return the subsequence with the maximum total sum of all its elements.
                A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.

            Note that the solution with the given constraints is guaranteed to be unique.
                Also return the answer sorted in non-increasing order.

        Example:
            Input: nums = [4,3,10,9,8]
            Output: [10,9]
            Explanation: The subsequences [10,9] and [10,8] are minimal
                such that the sum of their elements is strictly greater than the sum of elements not included.
                However, the subsequence [10,9] has the maximum total sum of its elements.""";

    public MinimumSubsequenceInNonIncreasingOrder(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 649 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 572 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 534 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
