package com.witalis.praxis.leetcode.task.h3.p268;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p268.option.*;
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
    id = 268,
    description = "Missing Number",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, MATH, BIT_MANIPULATION, SORTING}
)
public class MissingNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array nums containing n distinct numbers in the range [0, n],
                return the only number in the range that is missing from the array.

        Example:
            Input: nums = [9,6,4,2,3,5,7,0,1]
            Output: 8
            Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
                         8 is the missing number in the range since it does not appear in nums.""";

    public MissingNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        List<Integer> list = new ArrayList<>(
            IntStream.rangeClosed(0, len).boxed().toList()
        );
        Collections.shuffle(list);
        list.remove(0);
        this.numbers = list.stream().mapToInt(Integer::intValue).toArray();

        log.info("Length is '{}'", len);
        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2369 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1401 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 771 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
