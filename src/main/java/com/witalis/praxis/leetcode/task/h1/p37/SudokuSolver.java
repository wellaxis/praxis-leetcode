package com.witalis.praxis.leetcode.task.h1.p37;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p37.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 37,
    description = "Sudoku Solver",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BACKTRACKING, MATRIX}
)
public class SudokuSolver extends LeetCodeTask<char[][]> {
    private char[][] board;

    public static final String INFORMATION = """

        Write a program to solve a Sudoku puzzle by filling the empty cells.

        A sudoku solution must satisfy all of the following rules:
        1. Each of the digits 1-9 must occur exactly once in each row.
        2. Each of the digits 1-9 must occur exactly once in each column.
        3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

        The '.' character indicates empty cells.

        Example:
            Input: board =
                [["5","3",".",".","7",".",".",".","."]
                ,["6",".",".","1","9","5",".",".","."]
                ,[".","9","8",".",".",".",".","6","."]
                ,["8",".",".",".","6",".",".",".","3"]
                ,["4",".",".","8",".","3",".",".","1"]
                ,["7",".",".",".","2",".",".",".","6"]
                ,[".","6",".",".",".",".","2","8","."]
                ,[".",".",".","4","1","9",".",".","5"]
                ,[".",".",".",".","8",".",".","7","9"]]
            Output: board =
                [["5","3","4","6","7","8","9","1","2"]
                ,["6","7","2","1","9","5","3","4","8"]
                ,["1","9","8","3","4","2","5","6","7"]
                ,["8","5","9","7","6","1","4","2","3"]
                ,["4","2","6","8","5","3","7","9","1"]
                ,["7","1","3","9","2","4","8","5","6"]
                ,["9","6","1","5","3","7","2","8","4"]
                ,["2","8","7","4","1","9","6","3","5"]
                ,["3","4","5","2","8","6","1","7","9"]]
            """;

    public SudokuSolver(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.board = new char[][] {
            {'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            {'.','.','.','2','7','5','9','.','.'}
        };

        log.info("Board is:");
        for (char[] array : board) {
            log.info("{}", Arrays.toString(array));
        }
    }

    private char[][] cloneMatrix(char[][] matrix) {
        char[][] clone = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 19425 ms
    @Override
    protected char[][] original() {
        var original = new Original(cloneMatrix(board));
        return original.process();
    }

    // time = 17992 ms
    @Override
    protected char[][] practice() {
        var practice = new Practice(cloneMatrix(board));
        return practice.process();
    }

    // time = 2526 ms
    @Override
    protected char[][] solution() {
        var solution = new Solution(cloneMatrix(board));
        return solution.process();
    }
}
