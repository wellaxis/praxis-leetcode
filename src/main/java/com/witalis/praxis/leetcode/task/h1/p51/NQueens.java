package com.witalis.praxis.leetcode.task.h1.p51;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p51.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 51,
    description = "N-Queens",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BACKTRACKING}
)
public class NQueens extends LeetCodeTask<List<List<String>>> {
    public static final int LEN = 9;
    private int number;

    public static final String INFORMATION = """

        The n-queens puzzle is the problem of placing n queens on
            an n x n chessboard such that no two queens attack each other.

        Given an integer n, return all distinct solutions to the n-queens puzzle.
            You may return the answer in any order.

        Each solution contains a distinct board configuration of the n-queens' placement,
            where 'Q' and '.' both indicate a queen and an empty space, respectively.

        Example:
            Input: n = 4
            Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
            Explanation: There exist two distinct solutions to the 4-queens puzzle""";

    public NQueens(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);
        log.info("Number is: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 999 ms
    @Override
    protected List<List<String>> original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 961 ms
    @Override
    protected List<List<String>> practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 660 ms
    @Override
    protected List<List<String>> solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
