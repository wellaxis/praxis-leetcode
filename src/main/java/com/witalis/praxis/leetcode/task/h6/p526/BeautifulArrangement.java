package com.witalis.praxis.leetcode.task.h6.p526;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p526.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 526,
    description = "Beautiful Arrangement",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BACKTRACKING, BIT_MANIPULATION, BITMASK}
)
public class BeautifulArrangement extends LeetCodeTask<Integer> {
    public static final int DEFAULT_NUMBER = 12;
    private int number;

    public static final String INFORMATION = """

        Suppose you have n integers labeled 1 through n.
        A permutation of those n integers perm (1-indexed)
        is considered a beautiful arrangement
        if for every i (1 <= i <= n), either of the following is true:
            * perm[i] is divisible by i
            * i is divisible by perm[i]
        Given: an integer n, return the number of the beautiful arrangements
            that you can construct.
        Example:
            Input: n = 2
            Output: 2
        Explanation:
            The first beautiful arrangement is [1,2]:
                - perm[1] = 1 is divisible by i = 1
                - perm[2] = 2 is divisible by i = 2
            The second beautiful arrangement is [2,1]:
                - perm[1] = 2 is divisible by i = 1
                - i = 2 is divisible by perm[2] = 1""";

    public BeautifulArrangement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = DEFAULT_NUMBER;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 32674 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 51373 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
