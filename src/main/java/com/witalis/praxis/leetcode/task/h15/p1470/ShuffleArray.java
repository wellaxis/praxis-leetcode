package com.witalis.praxis.leetcode.task.h15.p1470;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1470.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1470,
    description = "Shuffle the Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class ShuffleArray extends LeetCodeTask<int[]> {
    public static final int LEN = 500;
    public static final int VALUE = 1_000;

    private int[] numbers;
    private int number;

    public static final String INFORMATION = """

        Description:
            Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

            Return the array in the form [x1,y1,x2,y2,...,xn,yn].

        Example:
            Input: nums = [2,5,1,3,4,7], n = 3
            Output: [2,3,5,4,1,7]
            Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].""";

    public ShuffleArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(2L * number, 1, VALUE + 1).toArray();

        log.info("Number: {}", number);
        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 574 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers, number);
        return original.process();
    }

    // time = 547 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers, number);
        return practice.process();
    }

    // time = 565 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers, number);
        return solution.process();
    }
}
