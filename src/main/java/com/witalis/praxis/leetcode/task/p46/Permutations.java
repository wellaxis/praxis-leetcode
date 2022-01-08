package com.witalis.praxis.leetcode.task.p46;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p46.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 46,
    description = "Permutations",
    tags = {ARRAY, BACKTRACKING}
)
public class Permutations extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 6;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an array nums of distinct integers,
            return all the possible permutations.
            You can return the answer in any order.

        Example:
            Input: nums = [1,2,3]
            Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]""";

    public Permutations(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        final int origin = -10;
        final int bound = 10;

        return ThreadLocalRandom.current()
            .ints(
                ThreadLocalRandom.current()
                    .nextInt(1, LEN + 1),
                origin,
                bound
            )
            .distinct()
            .toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3281 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 4541 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1715 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
