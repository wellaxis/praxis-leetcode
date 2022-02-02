package com.witalis.praxis.leetcode.task.h2.p169;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p169.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 169,
    description = "Majority Element",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, DIVIDE_AND_CONQUER, SORTING, COUNTING}
)
public class MajorityElement extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an array nums of size n, return the majority element.

        The majority element is the element that appears more than [n / 2] times.
            You may assume that the majority element always exists in the array.

        Example:
            Input: nums = [2,2,1,1,1,2,2]
            Output: 2""";

    public MajorityElement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int length = random.nextInt(1, LEN + 1);
        int majority = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int quantity = random.nextInt((length / 2) + 1, length);

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            integers.add(majority);
        }
        for (int i = quantity; i < length; i++) {
            integers.add(random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }
        Collections.shuffle(integers);
        this.numbers = integers.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers are {}", numbers);
        log.debug("Majority element is {}", majority);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 10639 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 3744 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1048 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
