package com.witalis.praxis.leetcode.task.h2.p130;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p130.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 130,
    description = "Surrounded Regions",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, MATRIX}
)
public class SurroundedRegions extends LeetCodeTask<char[][]> {
    public static final int LEN = 200;
    private char[][] board;

    public static final String INFORMATION = """

        Given an m x n matrix board containing 'X' and 'O',
            capture all regions that are 4-directionally surrounded by 'X'.

        A region is captured by flipping all 'O's into 'X's in that surrounded region.


        Example:
            Input: board =
                [["X","X","X","X"]
                ,["X","O","O","X"]
                ,["X","X","O","X"]
                ,["X","O","X","X"]]
            Output:
                [["X","X","X","X"]
                ,["X","X","X","X"]
                ,["X","X","X","X"]
                ,["X","O","X","X"]]
            Explanation:
                Surrounded regions should not be on the border,
                which means that any 'O' on the border of the board are not flipped to 'X'.
                Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
                Two cells are connected if they are adjacent cells connected horizontally or vertically.""";

    public SurroundedRegions(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int m = random.nextInt(1, LEN + 1);
        int n = random.nextInt(1, LEN + 1);

        this.board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = random.nextBoolean() ? 'X' : 'O';
            }
        }

        var builder = new StringBuilder("\n");
        for (char[] array : board) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Board [{} x {}] is {}", m, n, builder);
    }

    private static char[][] cloneMatrix(char[][] matrix) {
        if (matrix == null) return new char[0][0];

        return Arrays.stream(matrix)
                .map(char[]::clone)
                .toArray(char[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1295 ms
    @Override
    protected char[][] original() {
        var original = new Original(cloneMatrix(board));
        return original.process();
    }

    // time = 1090 ms
    @Override
    protected char[][] practice() {
        var practice = new Practice(cloneMatrix(board));
        return practice.process();
    }

    // time = 1012 ms
    @Override
    protected char[][] solution() {
        var solution = new Solution(cloneMatrix(board));
        return solution.process();
    }
}
