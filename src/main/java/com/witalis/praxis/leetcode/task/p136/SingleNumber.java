package com.witalis.praxis.leetcode.task.p136;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p136.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 136, description = "Single Number")
public class SingleNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 30_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given a non-empty array of integers nums,
            every element appears twice except for one. Find that single one.

        You must implement a solution with a linear runtime complexity
            and use only constant extra space.

        Example:
            Input: nums = [4,1,2,1,2]
            Output: 4""";

    public SingleNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();

        int[] distinct = random.ints(
                random.nextInt(1, LEN / 2),
                -VALUE,
                VALUE + 1
            )
            .distinct()
            .toArray();

        int single = distinct[0];

        int[] twice = new int[distinct.length * 2 - 1];
        twice[0] = single;
        System.arraycopy(distinct, 1, twice, 1, distinct.length - 1);
        System.arraycopy(distinct, 1, twice, distinct.length, distinct.length - 1);

        var ints = new ArrayList<>(Arrays.stream(twice).boxed().toList());

        Collections.shuffle(ints);

        return ints.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6581 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 858 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 968 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
