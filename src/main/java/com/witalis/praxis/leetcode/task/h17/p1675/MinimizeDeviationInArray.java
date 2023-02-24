package com.witalis.praxis.leetcode.task.h17.p1675;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1675.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1675,
    description = "Minimize Deviation in Array",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, GREEDY, HEAP, ORDERED_SET}
)
public class MinimizeDeviationInArray extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an array nums of n positive integers.

            You can perform two types of operations on any element of the array any number of times:
                * If the element is even, divide it by 2.
                    * For example, if the array is [1,2,3,4],
                      then you can do this operation on the last element, and the array will be [1,2,3,2].
                * If the element is odd, multiply it by 2.
                    * For example, if the array is [1,2,3,4],
                      then you can do this operation on the first element, and the array will be [2,2,3,4].

            The deviation of the array is the maximum difference between any two elements in the array.

            Return the minimum deviation the array can have after performing some number of operations.

        Example:
            Input: nums = [1,2,3,4]
            Output: 1
            Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.""";

    public MinimizeDeviationInArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 13722 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 14966 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 25127 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
