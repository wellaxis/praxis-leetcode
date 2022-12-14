package com.witalis.praxis.leetcode.task.h23.p2201.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 2201
 * Name: Count Artifacts That Can Be Extracted
 * URL: <a href="https://leetcode.com/problems/count-artifacts-that-can-be-extracted/">Count Artifacts That Can Be Extracted</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int dimension;
    private int[][] artifacts;
    private int[][] dig;

    public Integer process() {
        return digArtifacts(dimension, artifacts, dig);
    }

    record Point(int x, int y) {}

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        if (n == 0 || artifacts == null || dig == null) return 0;

        int counter = 0;

        Set<Point> digs = new HashSet<>();
        for (int[] oneDig : dig) {
            digs.add(new Point(oneDig[0], oneDig[1]));
        }

        boolean check;
        for (int[] artifact : artifacts) {
            if (!digs.contains(new Point(artifact[0], artifact[1]))) continue;

            digs.remove(new Point(artifact[0], artifact[1]));
            if (artifact[0] == artifact[2] && artifact[1] == artifact[3]) {
                counter++;
            } else if (artifact[0] == artifact[2]) {
                // vertical
                check = true;
                for (int y = artifact[1] + 1; y <= artifact[3]; y++) {
                    if (!digs.contains(new Point(artifact[0], y))) {
                        check = false;
                        break;
                    }
                    digs.remove(new Point(artifact[0], y));
                }
                if (check) counter++;
            } else if (artifact[1] == artifact[3]) {
                // horizontal
                check = true;
                for (int x = artifact[0] + 1; x <= artifact[2]; x++) {
                    if (!digs.contains(new Point(x, artifact[1]))) {
                        check = false;
                        break;
                    }
                    digs.remove(new Point(x, artifact[1]));
                }
                if (check) counter++;
            } else {
                // diagonal
                if (digs.contains(new Point(artifact[2], artifact[1])) &&
                    digs.contains(new Point(artifact[0], artifact[3])) &&
                    digs.contains(new Point(artifact[2], artifact[3]))
                ) {
                    counter++;
                    digs.remove(new Point(artifact[2], artifact[1]));
                    digs.remove(new Point(artifact[0], artifact[3]));
                    digs.remove(new Point(artifact[2], artifact[3]));
                }
            }
        }

        return counter;
    }
}
