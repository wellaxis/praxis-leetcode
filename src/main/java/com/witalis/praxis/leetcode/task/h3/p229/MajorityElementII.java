package com.witalis.praxis.leetcode.task.h3.p229;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p229.option.*;
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
    id = 229,
    description = "Majority Element II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, SORTING, COUNTING}
)
public class MajorityElementII extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 50_000;
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

        Example:
            Input: nums = [3,2,3]
            Output: [3]""";

    public MajorityElementII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int length = random.nextInt(1, LEN + 1);
        int majority = random.nextInt(-VALUE, VALUE + 1);

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length / 3 + 1; i++) {
            integers.add(majority);
        }
        for (int i = 0; i < length / 3 * 2; i++) {
            integers.add(random.nextInt(-VALUE, VALUE));
        }
        Collections.shuffle(integers);
        this.numbers = integers.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers are {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 11796 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 8569 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 5815 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
