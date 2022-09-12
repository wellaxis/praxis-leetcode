package com.witalis.praxis.leetcode.task.h6.p598;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p598.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 598,
    description = "Range Addition II",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH}
)
public class RangeAdditionII extends LeetCodeTask<Integer> {
    public static final int SIZE = 40_000;
    public static final int LEN = 10_000;
    private int[][] operations;
    private int rows;
    private int cols;

    public static final String INFORMATION = """

        You are given an m x n matrix M initialized with all 0's and an array of operations ops,
            where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

        Count and return the number of maximum integers in the matrix after performing all the operations.

        Example:
            Input: m = 3, n = 3, ops = [[2,2],[3,3]]
            Output: 4
            Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.""";

    public RangeAdditionII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.rows = random.nextInt(1, SIZE + 1);
        this.cols = random.nextInt(1, SIZE + 1);

        int len = random.nextInt(0, LEN + 1);
        this.operations = new int[len][2];
        for (int i = 0; i < len; i++) {
            operations[i] = new int[] {random.nextInt(1, rows), random.nextInt(1, cols)};
        }

        log.info("Rows: {}, Columns: {}", rows, cols);
        log.info("Operations: {}", printOperations(operations));
    }

    private static String printOperations(int[][] operations) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int[] row: operations) {
            builder.append("[").append(row[0]).append(",").append(row[1]).append("]").append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 12982 ms
    @Override
    protected Integer original() {
        var original = new Original(operations, rows, cols);
        return original.process();
    }

    // time = 864 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(operations, rows, cols);
        return practice.process();
    }

    // time = 663 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(operations, rows, cols);
        return solution.process();
    }
}
