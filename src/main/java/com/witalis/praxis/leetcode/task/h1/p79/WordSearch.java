package com.witalis.praxis.leetcode.task.h1.p79;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p79.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 79,
    description = "Word Search",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BACKTRACKING, MATRIX}
)
public class WordSearch extends LeetCodeTask<Boolean> {
    public static final int LEN = 15;
    public static final int SIZE = 6;

    private char[][] board;
    private String word;

    public static final String INFORMATION = """

        Given an m x n grid of characters board and a string word,
            return true if word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cells,
            where adjacent cells are horizontally or vertically neighboring.
            The same letter cell may not be used more than once.

        Example:
            Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
            Output: true""";

    public WordSearch(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, SIZE + 1);
        int columns = random.nextInt(1, SIZE + 1);

        this.board = new char[rows][columns];
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < columns; n++) {
                board[m][n] = (char) random.nextInt('A', 'A' + 26);
            }
        }

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder(len);
        for (int l = 0; l < len; l++) {
            builder.append((char) random.nextInt('A', 'A' + 26));
        }
        this.word = builder.toString();

        log.info("Board[{} x {}] is:", rows, columns);
        for (char[] row : board) {
            log.info("{}", Arrays.toString(row));
        }
        log.info("Word is {}", word);
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

    // time = 2576 ms
    @Override
    protected Boolean original() {
        var original = new Original(cloneMatrix(board), word);
        return original.process();
    }

    // time = 522 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(cloneMatrix(board), word);
        return practice.process();
    }

    // time = 595 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(cloneMatrix(board), word);
        return solution.process();
    }
}
