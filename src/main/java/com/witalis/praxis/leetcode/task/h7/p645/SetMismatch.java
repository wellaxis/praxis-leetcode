package com.witalis.praxis.leetcode.task.h7.p645;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p645.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 645,
    description = "Set Mismatch",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, BIT_MANIPULATION, SORTING}
)
public class SetMismatch extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        You have a set of integers s, which originally contains all the numbers from 1 to n.
            Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
            which results in repetition of one number and loss of another number.

        You are given an integer array nums representing the data status of this set after the error.

        Find the number that occurs twice and the number that is missing and return them in the form of an array.

        Example:
            Input: nums = [1,2,2,4]
            Output: [2,3]""";

    public SetMismatch(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        List<Integer> list = new ArrayList<>(IntStream.rangeClosed(1, len).boxed().toList());
        Collections.shuffle(list);
        this.numbers = list.stream().mapToInt(Integer::intValue).toArray();

        int duplicate = random.nextInt(0, len);
        int loss = random.nextInt(0, len);
        numbers[loss] = numbers[duplicate];

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2869 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 982 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 789 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
