package com.witalis.praxis.leetcode.task.h15.p1424;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1424.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1424,
    description = "Diagonal Traverse II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SORTING, HEAP}
)
public class DiagonalTraverseII extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private List<List<Integer>> numbers;

    public static final String INFORMATION = """

        Description:
            Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

        Example:
            Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
            Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]""";

    public DiagonalTraverseII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.numbers = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            int[] row = random.ints(
                random.nextInt(1, LEN + 1),
                1, VALUE + 1
            ).toArray();
            numbers.add(Arrays.stream(row).boxed().toList());
        }

        log.info("Numbers: {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 205727 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 187991 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 29576 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
