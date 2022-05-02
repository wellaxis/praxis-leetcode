package com.witalis.praxis.leetcode.task.h7.p661.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 661
 * Name: Image Smoother
 * URL: <a href="https://leetcode.com/problems/image-smoother/">Image Smoother</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] image;

    public int[][] process() {
        return imageSmoother(image);
    }

    public int[][] imageSmoother(int[][] img) {
        if (img == null || img[0] == null) return new int[][] {};

        int height = img.length;
        int width = img[0].length;

        int[][] smooth = new int[height][width];

        List<Integer> filter;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                filter = new ArrayList<>();
                for (int r = row - 1; r <= row + 1; r++) {
                    for (int c = col - 1; c <= col + 1; c++) {
                        if (r >= 0 && r < height && c >= 0 && c < width) {
                            filter.add(img[r][c]);
                        }
                    }
                }
                smooth[row][col] = (int) filter.stream().mapToInt(Integer::intValue).average().getAsDouble();
            }
        }

        return smooth;
    }
}
