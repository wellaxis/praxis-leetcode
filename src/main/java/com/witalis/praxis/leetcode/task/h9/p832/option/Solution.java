package com.witalis.praxis.leetcode.task.h9.p832.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 832
 * Name: Flipping an Image
 * URL: <a href="https://leetcode.com/problems/flipping-an-image/">Flipping an Image</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] image;

    public int[][] process() {
        return flipAndInvertImage(image);
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for (int[] row : image)
            for (int i = 0; i < (n + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[n - 1 - i] ^ 1;
                row[n - 1 - i] = tmp;
            }

        return image;
    }
}
