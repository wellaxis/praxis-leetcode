package com.witalis.praxis.leetcode.task.h13.p1287;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1287.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1287,
    description = "Element Appearing More Than 25% In Sorted Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class ElementAppearingMoreThan25PercentInSortedArray extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private int[] array;

    public static final String INFORMATION = """

        Description:
            Given an integer array sorted in non-decreasing order, there is exactly one integer in the array
                that occurs more than 25% of the time, return that integer.

        Example:
            Input: arr = [1,2,2,6,6,6,6,7,10]
            Output: 6""";

    public ElementAppearingMoreThan25PercentInSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.array = random.ints(
            random.nextInt(1, LEN + 1),
            0, LEN + 1
        ).sorted().toArray();

        log.info("Array: {}", Arrays.toString(array));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 529 ms
    @Override
    protected Integer original() {
        var original = new Original(array);
        return original.process();
    }

    // time = 525 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(array);
        return practice.process();
    }

    // time = 471 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(array);
        return solution.process();
    }
}
