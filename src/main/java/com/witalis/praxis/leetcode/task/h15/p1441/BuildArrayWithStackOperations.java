package com.witalis.praxis.leetcode.task.h15.p1441;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1441.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1441,
    description = "Build an Array With Stack Operations",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STACK, SIMULATION}
)
public class BuildArrayWithStackOperations extends LeetCodeTask<List<String>> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private int[] target;
    private int number;

    public static final String INFORMATION = """

        Description:
            You are given an integer array target and an integer n.

            You have an empty stack with the two following operations:
                * "Push": pushes an integer to the top of the stack.
                * "Pop": removes the integer on the top of the stack.

            You also have a stream of the integers in the range [1, n].

            Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target.
                You should follow the following rules:
                * If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
                * If the stack is not empty, pop the integer at the top of the stack.
                * If, at any moment, the elements in the stack (from the bottom to the top) are equal to target,
                  do not read new integers from the stream and do not do more operations on the stack.

            Return the stack operations needed to build target following the mentioned rules.
                If there are multiple valid answers, return any of them.

        Example:
            Input: target = [1,3], n = 3
            Output: ["Push","Push","Pop","Push"]
            Explanation: Initially the stack s is empty. The last element is the top of the stack.
                Read 1 from the stream and push it to the stack. s = [1].
                Read 2 from the stream and push it to the stack. s = [1,2].
                Pop the integer on the top of the stack. s = [1].
                Read 3 from the stream and push it to the stack. s = [1,3].""";

    public BuildArrayWithStackOperations(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, VALUE + 1);
        this.target = random.ints(
            random.nextInt(1, LEN + 1),
            1, number + 1
        ).distinct().sorted().toArray();

        log.info("Number 'n': {}", number);
        log.info("Target: {}", Arrays.toString(target));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 687 ms
    @Override
    protected List<String> original() {
        var original = new Original(target, number);
        return original.process();
    }

    // time = 510 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(target, number);
        return practice.process();
    }

    // time = 461 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(target, number);
        return solution.process();
    }
}
