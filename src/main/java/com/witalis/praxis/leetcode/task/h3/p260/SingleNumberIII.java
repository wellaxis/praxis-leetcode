package com.witalis.praxis.leetcode.task.h3.p260;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p260.option.*;
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
    id = 260,
    description = "Single Number III",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BIT_MANIPULATION}
)
public class SingleNumberIII extends LeetCodeTask<int[]> {
    public static final int LEN = 30_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums, in which exactly two elements appear only once
            and all the other elements appear exactly twice.
            Find the two elements that appear only once. You can return the answer in any order.

        You must write an algorithm that runs in linear runtime complexity
            and uses only constant extra space.

        Example:
            Input: nums = [1,2,1,3,2,5]
            Output: [3,5]
            Explanation: [5, 3] is also a valid answer.""";

    public SingleNumberIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN / 2);
        int[] distinct = random.ints(len, Integer.MIN_VALUE, Integer.MAX_VALUE)
            .distinct()
            .toArray();

        List<Integer> thrice = new ArrayList<>();
        thrice.add(distinct[0]);
        thrice.add(distinct[1]);
        for (int i = 2; i < distinct.length; i++) {
            thrice.add(distinct[i]);
            thrice.add(distinct[i]);
        }
        Collections.shuffle(thrice);

        return thrice.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1593 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1556 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1522 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
