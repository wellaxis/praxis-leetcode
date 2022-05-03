package com.witalis.praxis.leetcode.task.h7.p661;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p661.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 661,
    description = "Image Smoother",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX}
)
public class ImageSmoother extends LeetCodeTask<int[][]> {
    public static final int LEN = 200;
    public static final int VALUE = 255;
    private int[][] image;

    public static final String INFORMATION = """

        An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image
            by rounding down the average of the cell and the eight surrounding cells
            (i.e., the average of the nine cells in the blue smoother).
            If one or more of the surrounding cells of a cell is not present,
            we do not consider it in the average (i.e., the average of the four cells in the red smoother).

        Given an m x n integer matrix img representing the grayscale of an image,
            return the image after applying the smoother on each cell of it.

        Example:
            Input: img = [[100,200,100],[200,50,200],[100,200,100]]
            Output: [[137,141,137],[141,138,141],[137,141,137]]
            Explanation:
                For the points (0,0), (0,2), (2,0), (2,2):
                    floor((100+200+200+50)/4) = floor(137.5) = 137
                For the points (0,1), (1,0), (1,2), (2,1):
                    floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
                For the point (1,1):
                    floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138""";

    public ImageSmoother(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.image = generate();

        log.info("Image:");
        printImage(image);
    }

    private int[][] generate() {
        var random = ThreadLocalRandom.current();

        int height = random.nextInt(1, LEN + 1);
        int width = random.nextInt(1, LEN + 1);

        int[][] image = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image[i][j] = random.nextInt(0, VALUE + 1);
            }
        }
        return image;
    }

    private static void printImage(int[][] image) {
        var format = "%" + String.valueOf(VALUE).length() + "d";

        log.info("-".repeat(6 * image[0].length + 1));
        for (int[] row : image) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(6 * image[0].length + 1));
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

    // time = 20230 ms
    @Override
    protected int[][] original() {
        var original = new Original(image);
        return original.process();
    }

    // time = 3546 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(image);
        return practice.process();
    }

    // time = 5324 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(image);
        return solution.process();
    }
}
