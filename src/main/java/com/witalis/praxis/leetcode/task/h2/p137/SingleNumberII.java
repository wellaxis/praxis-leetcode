package com.witalis.praxis.leetcode.task.h2.p137;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p137.option.*;
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
    id = 137,
    description = "Single Number II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BIT_MANIPULATION}
)
public class SingleNumberII extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums where every element appears three times
            except for one, which appears exactly once.
            Find the single element and return it.

        You must implement a solution with a linear runtime complexity
            and use only constant extra space.

        Example:
            Input: nums = [0,1,0,1,0,1,99]
            Output: 99""";

    public SingleNumberII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN / 3);
        int[] distinct = random.ints(len, Integer.MIN_VALUE, Integer.MAX_VALUE)
            .distinct()
            .toArray();

        List<Integer> thrice = new ArrayList<>();
        thrice.add(distinct[0]);
        for (int i = 1; i < distinct.length; i++) {
            for (int j = 0; j < 3; j++) {
                thrice.add(distinct[i]);
            }
        }
        Collections.shuffle(thrice);

        return thrice.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6245 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 3838 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1027 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
