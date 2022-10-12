package com.witalis.praxis.leetcode.task.h3.p289;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p289.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 289,
    description = "Game of Life",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class GameOfLife extends LeetCodeTask<int[][]> {
    public static final int LEN = 25;
    private int[][] board;

    public static final String INFORMATION = """

        According to Wikipedia's article: "The Game of Life, also known simply as Life,
            is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

        The board is made up of an m x n grid of cells, where each cell has an initial state:
            live (represented by a 1) or dead (represented by a 0).
            Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
            using the following four rules (taken from the above Wikipedia article):
            * Any live cell with fewer than two live neighbors dies as if caused by under-population.
            * Any live cell with two or three live neighbors lives on to the next generation.
            * Any live cell with more than three live neighbors dies, as if by over-population.
            * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

        The next state is created by applying the above rules simultaneously to every cell in the current state,
            where births and deaths occur simultaneously.
            Given the current state of the m x n grid board, return the next state.

        Example:
            Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
            Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]""";

    public GameOfLife(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int columns = random.nextInt(1, LEN + 1);

        this.board = new int[rows][columns];
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < columns; n++) {
                board[m][n] = random.nextBoolean() ? 1 : 0;
            }
        }

        log.info("Board[{} x {}] is:", rows, columns);
        for (int[] row : board) {
            log.info("{}", Arrays.toString(row));
        }
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 14154 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneMatrix(board));
        return original.process();
    }

    // time = 2538 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneMatrix(board));
        return practice.process();
    }

    // time = 908 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneMatrix(board));
        return solution.process();
    }
}
