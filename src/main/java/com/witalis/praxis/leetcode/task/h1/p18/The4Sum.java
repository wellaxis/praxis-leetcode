package com.witalis.praxis.leetcode.task.h1.p18;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p18.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 18,
    description = "4Sum",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, SORTING}
)
public class The4Sum extends LeetCodeTask<List<List<Integer>>> {
    public static final int MAX = (int) Math.pow(10, 9);
    public static final int LEN = 200;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Given an array nums of n integers,
            return an array of all the unique quadruplets
            [nums[a], nums[b], nums[c], nums[d]] such that:
                                                
        * 0 <= a, b, c, d < n
        * a, b, c, and d are distinct.
        * nums[a] + nums[b] + nums[c] + nums[d] == target
        
        You may return the answer in any order.
        
        Example:
            Input: nums = [1,0,-1,0,-2,2], target = 0
            Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]""";

    public The4Sum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = IntStream.generate(
                () -> random.nextInt(-MAX, MAX + 1)
            )
            .limit(random.nextInt(1, LEN + 1))
            .toArray();
        this.target = random.nextInt(-MAX, MAX + 1);

        log.info("Numbers are {}, target is {}", numbers, target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3379 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 1914 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 2200 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
