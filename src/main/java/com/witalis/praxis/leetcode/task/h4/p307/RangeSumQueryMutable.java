package com.witalis.praxis.leetcode.task.h4.p307;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p307.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 307,
    description = "Range Sum Query - Mutable",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DESIGN, BINARY_INDEXED_TREE, SEGMENT_TREE}
)
public class RangeSumQueryMutable extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 30_000;
    public static final int VALUE = 100;
    private int[] numbers;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, handle multiple queries of the following types:
                * Update the value of an element in nums.
                * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

            Implement the NumArray class:
                * NumArray(int[] nums) Initializes the object with the integer array nums.
                * void update(int index, int val) Updates the value of nums[index] to be val.
                * int sumRange(int left, int right) Returns the sum of the elements of nums between indices
                  left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

        Example:
            Input:
                ["NumArray", "sumRange", "update", "sumRange"]
                [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
            Output:
                [null, 9, null, 8]
            Explanation:
                NumArray numArray = new NumArray([1, 3, 5]);
                numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
                numArray.update(1, 2);   // nums = [1, 2, 5]
                numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8""";

    public RangeSumQueryMutable(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(len, -VALUE, VALUE + 1).toArray();

        log.info("Numbers are: {}", Arrays.toString(numbers));

        operations = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        int size = random.nextInt(1, LEN + 1);
        for (int i = 0; i < size; i++) {
            int[] data;
            String action;
            if (random.nextBoolean()) {
                action = "update";
                int index = random.nextInt(0, numbers.length);
                int value = random.nextInt(-VALUE, VALUE + 1);
                data = new int[] {index, value};
            } else {
                action = "sumRange";
                int left = random.nextInt(0, numbers.length);
                int right = random.nextInt(left, numbers.length);
                data = new int[] {left, right};
            }
            operations.add(new AbstractMap.SimpleEntry<>(action, data));
            actions.add(String.format("%s [%d, %d]", action, data[0], data[1]));
        }

        log.info("Actions are: {}", actions);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 57514 ms, time limit exceeded
    @Override
    protected List<Integer> original() {
        var original = new Original(operations, numbers.clone());
        return original.process();
    }

    // time = 24166 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations, numbers.clone());
        return practice.process();
    }

    // time = 11735 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations, numbers.clone());
        return solution.process();
    }
}
