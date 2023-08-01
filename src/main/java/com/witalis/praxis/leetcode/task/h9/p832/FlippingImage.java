package com.witalis.praxis.leetcode.task.h9.p832;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p832.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 832,
    description = "Flipping an Image",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, MATRIX, SIMULATION}
)
public class FlippingImage extends LeetCodeTask<int[][]> {
    public static final int LEN = 20;

    private int[][] image;

    public static final String INFORMATION = """

        Description:
            Given an n x n binary matrix image, flip the image horizontally,
                then invert it, and return the resulting image.

            To flip an image horizontally means that each row of the image is reversed.
                * For example, flipping [1,1,0] horizontally results in [0,1,1].

            To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
                * For example, inverting [0,1,1] results in [1,0,0].

        Example:
            Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
            Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
            Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
                Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]""";

    public FlippingImage(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.image = generate();

        log.info("Image:");
        printImage(image);
    }

    private int[][] generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        int[][] image = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                image[i][j] = random.nextBoolean() ? 1 : 0;
            }
        }
        return image;
    }

    private static void printImage(int[][] image) {
        var format = "%1d";

        log.info("-".repeat(4 * image[0].length + 1));
        for (int[] row : image) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * image[0].length + 1));
        }
        log.info("Image [{}][{}] has been generated successfully.", image.length, image[0].length);
    }

    private static int[][] cloneImage(int[][] image) {
        if (image == null) return new int[0][0];

        return Arrays.stream(image)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 479 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneImage(image));
        return original.process();
    }

    // time = 453 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneImage(image));
        return practice.process();
    }

    // time = 498 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneImage(image));
        return solution.process();
    }
}
