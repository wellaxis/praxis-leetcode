package com.witalis.praxis.leetcode.task.h1.p36;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p36.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 36,
    description = "Valid Sudoku",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, MATRIX}
)
public class ValidSudoku extends LeetCodeTask<Boolean> {
    private char[][] board;

    public static final String INFORMATION = """

        Determine if a 9 x 9 Sudoku board is valid.
            Only the filled cells need to be validated
            according to the following rules:
                                                    
        1. Each row must contain the digits 1-9 without repetition.
        2. Each column must contain the digits 1-9 without repetition.
        3. Each of the nine 3 x 3 sub-boxes of the grid
           must contain the digits 1-9 without repetition.
        
        Note:
        * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        * Only the filled cells need to be validated according to the mentioned rules.

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
            Output: true""";

    public ValidSudoku(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.board = new char[][] {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        log.info("Board is:");
        for (char[] array : board) {
            log.info("{}", Arrays.toString(array));
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2561 ms
    @Override
    protected Boolean original() {
        var original = new Original(board.clone());
        return original.process();
    }

    // time = 1440 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(board.clone());
        return practice.process();
    }

    // time = 741 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(board.clone());
        return solution.process();
    }
}
