package com.witalis.praxis.leetcode.task.h9.p864;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p864.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 864,
    description = "Shortest Path to Get All Keys",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BIT_MANIPULATION, BREADTH_FIRST_SEARCH, MATRIX}
)
public class ShortestPathToGetAllKeys extends LeetCodeTask<Integer> {
    public static final int LEN = 30;

    private String[] grid;

    public static final String INFORMATION = """

        Description:
            You are given an m x n grid grid where:
                * '.' is an empty cell.
                * '#' is a wall.
                * '@' is the starting point.
                * Lowercase letters represent keys.
                * Uppercase letters represent locks.

            You start at the starting point and one move consists of walking one space in one of the four cardinal directions.
                You cannot walk outside the grid, or walk into a wall.

            If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.

            For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter
                of the first k letters of the English alphabet in the grid.
                This means that there is exactly one key for each lock, and one lock for each key;
                and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

            Return the lowest number of moves to acquire all keys. If it is impossible, return -1.

        Example:
            Input: grid = ["@.a..","###.#","b.A.B"]
            Output: 8
            Explanation: Note that the goal is to obtain all the keys not to open all the locks.""";

    public ShortestPathToGetAllKeys(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int k = 6;
        final int w = 3;
        final int m = random.nextInt(1, LEN + 1);
        final int n = random.nextInt(1, LEN + 1);

        int keys = m * n / k;
        if (keys > 26) keys = 26;

        final int walls = m * n / w;

        final char[][] matrix = new char[m][n];
        for (char[] row : matrix)
            Arrays.fill(row, '.');

        matrix[0][0] = '@';

        int row = 1;
        int col = 1;
        int counter = 0;
        while (counter <= keys) {
            // key
            while (Character.isLetter(matrix[row][col])) {
                row = random.nextInt(1, m);
                col = random.nextInt(1, n);
            }
            matrix[row][col] = (char) ('a' + counter);
            // lock
            while (Character.isLetter(matrix[row][col])) {
                row = random.nextInt(1, m);
                col = random.nextInt(1, n);
            }
            matrix[row][col] = (char) ('A' + counter);

            counter++;
        }

        counter = 0;
        while (counter <= walls) {
            row = random.nextInt(0, m);
            col = random.nextInt(0, n);
            if (matrix[row][col] == '.') {
                matrix[row][col] = '#';
                counter++;
            }
        }

        this.grid = new String[m];
        for (int i = 0; i < m; i++) {
            grid[i] = new String(matrix[i]);
        }

        log.info("Grid:");
        printGrid(matrix);
    }

    private static void printGrid(char[][] matrix) {
        log.info("-".repeat(4 * matrix[0].length + 1));
        for (char[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (char value : row) {
                builder
                    .append(value)
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * matrix[0].length + 1));
        }
        log.info("Grid [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 13594 ms
    @Override
    protected Integer original() {
        var original = new Original(grid);
        return original.process();
    }

    // time = 8134 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(grid);
        return practice.process();
    }

    // time = 1977 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(grid);
        return solution.process();
    }
}
