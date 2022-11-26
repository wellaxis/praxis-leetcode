package com.witalis.praxis.leetcode.task.h8.p733;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p733.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 733,
    description = "Flood Fill",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, MATRIX}
)
public class FloodFill extends LeetCodeTask<int[][]> {
    public static final int LEN = 50;
    public static final int COLORS = 8;
    private int[][] image;
    private int centerRow;
    private int centerCol;
    private int floodColor;

    public static final String INFORMATION = """

        Description:
            An image is represented by an m x n integer grid image
                where image[i][j] represents the pixel value of the image.

            You are also given three integers sr, sc, and color.
                You should perform a flood fill on the image starting from the pixel image[sr][sc].

            To perform a flood fill, consider the starting pixel, plus any pixels
                connected 4-directionally to the starting pixel of the same color as the starting pixel,
                plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
                Replace the color of all of the aforementioned pixels with color.

            Return the modified image after performing the flood fill.

        Example:
            Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
            Output: [[2,2,2],[2,2,0],[2,0,1]]
            Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
                all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
                Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.""";

    public FloodFill(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int height = random.nextInt(1, LEN + 1);
        int width = random.nextInt(1, LEN + 1);

        this.image = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image[i][j] = random.nextInt(0, COLORS + 1);
            }
        }

        this.centerRow = random.nextInt(0, height);
        this.centerCol = random.nextInt(0, width);
        this.floodColor = random.nextInt(0, COLORS + 1);

        log.info("Image:");
        printImage(image);
        log.info("Center is [row = {}, column = {}]", centerRow, centerCol);
        log.info("Flood color is {}", floodColor);
    }

    private static void printImage(int[][] matrix) {
        log.info("-".repeat(4 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format("%1d", value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * matrix[0].length + 1));
        }
        log.info("Image [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    private static int[][] cloneMatrix(int[][] image) {
        if (image == null) return new int[0][0];

        return Arrays.stream(image)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1236 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneMatrix(image), centerRow, centerCol, floodColor);
        return original.process();
    }

    // time = 952 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneMatrix(image), centerRow, centerCol, floodColor);
        return practice.process();
    }

    // time = 507 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneMatrix(image), centerRow, centerCol, floodColor);
        return solution.process();
    }
}
