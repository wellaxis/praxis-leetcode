package com.witalis.praxis.leetcode.task.h3.p283;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p283.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 283,
    description = "Move Zeroes",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS}
)
public class MoveZeroes extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, move all 0's to the end
                of it while maintaining the relative order of the non-zero elements.

            Note that you must do this in-place without making a copy of the array.

            Example:
                Input: nums = [0,1,0,3,12]
                Output: [1,3,12,0,0]""";

    public MoveZeroes(int id, String description, TaskRevision revision) {
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
        int lenZeroes = random.nextInt(0, len);
        List<Integer> data = new ArrayList<>(
            random.ints(
                random.nextInt(1, LEN + 1),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
            ).boxed().toList()
        );
        while (lenZeroes-- > 0) data.add(0);
        Collections.shuffle(data);
        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 346 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 335 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 386 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
