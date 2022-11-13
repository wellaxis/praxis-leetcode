package com.witalis.praxis.leetcode.task.h4.p324;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p324.option.*;
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
    id = 324,
    description = "Wiggle Sort II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DIVIDE_AND_CONQUER, SORTING, QUICK_SELECT}
)
public class WiggleSortII extends LeetCodeTask<int[]> {
    public static final int LEN = 50_000;
    public static final int VALUE = 5_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

            You may assume the input array always has a valid answer.

        Example:
            Input: nums = [1,5,1,1,6,4]
            Output: [1,6,1,5,1,4]
            Explanation: [1,4,1,5,1,6] is also accepted.""";

    public WiggleSortII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        boolean less = true;
        int previous = random.nextInt(0, VALUE + 1);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            integers.add(
                less
                    ? previous - random.nextInt(1, previous)
                    : previous + random.nextInt(1, VALUE - previous)
            );
            less = !less;
            previous = integers.get(i);
        }
        Collections.shuffle(integers);
        this.numbers = integers.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9816 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 6595 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 7087 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
