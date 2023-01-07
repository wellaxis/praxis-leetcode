package com.witalis.praxis.leetcode.task.h21.p2011;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2011.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2011,
    description = "Final Value of Variable After Performing Operations",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, STRING, SIMULATION}
)
public class FinalValueOfVariableAfterPerformingOperations extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private String[] operations;

    public static final String INFORMATION = """

        Description:
            There is a programming language with only four operations and one variable X:
                * ++X and X++ increments the value of the variable X by 1.
                * --X and X-- decrements the value of the variable X by 1.

            Initially, the value of X is 0.

            Given an array of strings operations containing a list of operations,
                return the final value of X after performing all the operations.

        Example:
            Input: operations = ["X++","++X","--X","X--"]
            Output: 0
            Explanation: The operations are performed as follows:
                Initially, X = 0.
                X++: X is incremented by 1, X = 0 + 1 = 1.
                ++X: X is incremented by 1, X = 1 + 1 = 2.
                --X: X is decremented by 1, X = 2 - 1 = 1.
                X--: X is decremented by 1, X = 1 - 1 = 0.""";

    public FinalValueOfVariableAfterPerformingOperations(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.operations = new String[len];
        for (int i = 0; i < len; i++) {
            int mode = random.nextInt(0, 4);
            operations[i] = switch (mode) {
                case 0 -> "X++";
                case 1 -> "++X";
                case 2 -> "--X";
                case 3 -> "X--";
                default -> throw new IllegalStateException("Unexpected value: " + mode);
            };
        }

        log.info("Operations: {}", Arrays.toString(operations));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 759 ms
    @Override
    protected Integer original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 640 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 605 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
