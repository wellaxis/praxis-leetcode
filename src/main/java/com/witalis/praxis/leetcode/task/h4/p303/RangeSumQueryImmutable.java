package com.witalis.praxis.leetcode.task.h4.p303;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p303.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 303,
    description = "Range Sum Query - Immutable",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DESIGN, PREFIX_SUM}
)
public class RangeSumQueryImmutable extends LeetCodeTask<List<Integer>> {
    public static final int QTY = 10_000;
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;
    private int[] numbers;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Given an integer array nums, handle multiple queries of the following type:
            1. Calculate the sum of the elements of nums
            between indices left and right inclusive where left <= right.

        Implement the NumArray class:
            * NumArray(int[] nums) Initializes the object with the integer array nums.
            * int sumRange(int left, int right) Returns the sum of the elements
              of nums between indices left and right inclusive
              (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

        Example:
            Input
                ["NumArray", "sumRange", "sumRange", "sumRange"]
                [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
            Output
                [null, 1, -1, -3]
            Explanation
                NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
                numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
                numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
                numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3""";

    public RangeSumQueryImmutable(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(0, LEN + 1);
        int qty = random.nextInt(0, QTY + 1);

        operations = new ArrayList<>();

        this.numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = random.nextInt(-VALUE, VALUE + 1);
        }
        operations.add(new AbstractMap.SimpleEntry<>("NumArray", numbers));

        for (int i = 0; i < qty; i++) {
            int left = random.nextInt(0, len);
            int right = random.nextInt(0, len);
            int[] range = new int[] {
                Math.min(left, right),
                Math.max(left, right)
            };
            operations.add(new AbstractMap.SimpleEntry<>("sumRange", range));
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 49685 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(numbers.clone(), operations);
        return original.process();
    }

    // time = 7939 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(numbers.clone(), operations);
        return practice.process();
    }

    // time = 4059 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(numbers.clone(), operations);
        return solution.process();
    }
}
