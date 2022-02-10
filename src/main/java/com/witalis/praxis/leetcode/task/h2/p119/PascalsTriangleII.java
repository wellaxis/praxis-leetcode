package com.witalis.praxis.leetcode.task.h2.p119;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p119.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 119,
    description = "Pascal's Triangle",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class PascalsTriangleII extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 33;
    private int index;

    public static final String INFORMATION = """

        Given an integer rowIndex,
            return the rowIndex th (0-indexed) row
            of the Pascal's triangle.

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
            Input: numRows = 3
            Output: [1,3,3,1]""";

    public PascalsTriangleII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.index = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Index of row is '{}'", index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 925 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(index);
        return original.process();
    }

    // time = 805 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(index);
        return practice.process();
    }

    // time = 710 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(index);
        return solution.process();
    }
}
