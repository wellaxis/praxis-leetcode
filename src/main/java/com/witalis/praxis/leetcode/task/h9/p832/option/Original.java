package com.witalis.praxis.leetcode.task.h9.p832.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 832
 * Name: Flipping an Image
 * URL: <a href="https://leetcode.com/problems/flipping-an-image/">Flipping an Image</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] image;

    public int[][] process() {
        return flipAndInvertImage(image);
    }

    public int[][] flipAndInvertImage(int[][] image) {
        if (image == null) return new int[0][];

        final int n = image.length;

        for (int[] row : image) {
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int left = row[l];
                int right = row[r];

                row[l] = 1 - right;
                row[r] = 1 - left;

                l++;
                r--;
            }
        }

        return image;
    }
}
