package com.witalis.praxis.leetcode.task.h10.p961;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p961.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 961,
    description = "N-Repeated Element in Size 2N Array",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE}
)
public class NRepeatedElementInSize2NArray extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums with the following properties:
                * nums.length == 2 * n.
                * nums contains n + 1 unique elements.
                * Exactly one element of nums is repeated n times.

            Return the element that is repeated n times.

        Example:
            Input: nums = [5,1,5,2,5,3,5,4]
            Output: 5""";

    public NRepeatedElementInSize2NArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(2, LEN + 1);
        List<Integer> nums = new ArrayList<>(
            random.ints(
                n + 1,
                0, VALUE + 1
            ).distinct().boxed().toList()
        );
        int duplicate = nums.get(0);
        n = nums.size();
        for (int i = 0; i < n; i++)
            nums.add(duplicate);
        Collections.shuffle(nums);

        this.numbers = nums.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 642 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 516 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 444 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
