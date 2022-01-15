package com.witalis.praxis.leetcode.task.h1.p47;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p47.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 47,
    description = "Permutations II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BACKTRACKING}
)
public class PermutationsII extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 8;
    public static final int VALUE = 10;
    private int[] numbers;

    public static final String INFORMATION = """

        Given a collection of numbers, nums, that might contain duplicates,
            return all possible unique permutations in any order.

        Example:
            Input: nums = [1,1,2]
            Output: [[1,1,2],[1,2,1],[2,1,1]]""";

    public PermutationsII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        return ThreadLocalRandom.current()
            .ints(
                ThreadLocalRandom.current()
                    .nextInt(1, LEN + 1),
                -VALUE,
                VALUE
            )
            .toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 781 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 433 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 424 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
