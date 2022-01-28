package com.witalis.praxis.leetcode.task.h2.p118;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p118.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;


@Slf4j
@LeetCode(
    id = 118,
    description = "Pascal's Triangle",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class PascalsTriangle extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 30;
    private int rows;

    public static final String INFORMATION = """

        Given an integer numRows,
            return the first numRows of Pascal's triangle.

        In Pascal's triangle, each number is the sum of
            the two numbers directly above it as shown:
            
                    1
                   / \\
                  1   1
                 / \\ / \\
                1   2   1
               / \\ / \\ / \\
              1   3   3   1
             / \\ / \\ / \\ / \\
            1   4   6   4   1

        Example:
            Input: numRows = 5
            Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]""";

    public PascalsTriangle(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.rows = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number of rows is '{}'", rows);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 566 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(rows);
        return original.process();
    }

    // time = 437 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(rows);
        return practice.process();
    }

    // time = 514 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(rows);
        return solution.process();
    }
}
