package com.witalis.praxis.leetcode.task.p45;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p45.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 45,
    description = "Jump Game II",
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY}
)
public class JumpGameII extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an array of non-negative integers nums,
            you are initially positioned at the first index of the array.

        Each element in the array represents your
            maximum jump length at that position.

        Your goal is to reach the last index in the minimum number of jumps.

        You can assume that you can always reach the last index.

        Example:
            Input: nums = [2,3,1,1,4]
            Output: 2
            Explanation: The minimum number of jumps to reach the last index is 2.
                Jump 1 step from index 0 to 1, then 3 steps to the last index.""";

    public JumpGameII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();
        return random.ints(
                ThreadLocalRandom.current()
                    .nextInt(1, LEN + 1),
                0,
                VALUE
            ).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 27654 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 769 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 729 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
