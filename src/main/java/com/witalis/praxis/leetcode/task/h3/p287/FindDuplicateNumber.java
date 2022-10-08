package com.witalis.praxis.leetcode.task.h3.p287;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p287.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 287,
    description = "Find the Duplicate Number",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, BINARY_SEARCH, BIT_MANIPULATION}
)
public class FindDuplicateNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an array of integers nums containing n + 1 integers
            where each integer is in the range [1, n] inclusive.

        There is only one repeated number in nums, return this repeated number.

        You must solve the problem without modifying the array nums and uses only constant extra space.

        Example:
            Input: nums = [1,3,4,2,2]
            Output: 2""";

    public FindDuplicateNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> data = new ArrayList<>(IntStream.rangeClosed(1, len).boxed().toList());
        int duplicate = random.nextInt(1, len);
        int repeats = random.nextInt(1, 10);
        while (repeats >= 0) {
            data.set(random.nextInt(1, len), duplicate);
            repeats--;
        }
        Collections.shuffle(data);
        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2892 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 646 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 4799 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
