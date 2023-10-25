package com.witalis.praxis.leetcode.task.h8.p779;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p779.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 779,
    description = "K-th Symbol in Grammar",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, BIT_MANIPULATION, RECURSION}
)
public class KthSymbolInGrammar extends LeetCodeTask<Integer> {
    public static final int LEN = 30;

    private int row;
    private int col;

    public static final String INFORMATION = """

        Description:
            We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
                Now in every subsequent row, we look at the previous row and replace
                each occurrence of 0 with 01, and each occurrence of 1 with 10.

            * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.

            Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

        Example:
            Input: n = 2, k = 2
            Output: 1
            Explanation:
                row 1: 0
                row 2: 01""";

    public KthSymbolInGrammar(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.row = random.nextInt(1, LEN + 1);
        this.col = random.nextInt(1, (int) Math.pow(2, row - 1D));

        log.info("Row 'n': {}", row);
        log.info("Col 'k': {}", col);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 558 ms
    @Override
    protected Integer original() {
        var original = new Original(row, col);
        return original.process();
    }

    // time = 533 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(row, col);
        return practice.process();
    }

    // time = 443 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(row, col);
        return solution.process();
    }
}
