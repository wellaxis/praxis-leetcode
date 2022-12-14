package com.witalis.praxis.leetcode.task.h23.p2201.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ID: 2201
 * Name: Count Artifacts That Can Be Extracted
 * URL: <a href="https://leetcode.com/problems/count-artifacts-that-can-be-extracted/">Count Artifacts That Can Be Extracted</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int dimension;
    private int[][] artifacts;
    private int[][] dig;

    public Integer process() {
        return digArtifacts(dimension, artifacts, dig);
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        if (n == 0 || artifacts == null || dig == null) return 0;

        int counter = 0;
        Set<List<Integer>> digs = Arrays.stream(dig).map(arr -> List.of(arr[0], arr[1])).collect(Collectors.toSet());
        for (int[] artifact : artifacts) {
            if (!digs.contains(List.of(artifact[0], artifact[1]))) continue;

            if (artifact[0] == artifact[2] && artifact[1] == artifact[3]) {
                counter++;
            } else if (artifact[0] == artifact[2]) {
                // vertical
                boolean check = true;
                for (int y = artifact[1] + 1; y <= artifact[3]; y++) {
                    if (!digs.contains(List.of(artifact[0], y))) {
                        check = false;
                        break;
                    }
                }
                if (check) counter++;
            } else if (artifact[1] == artifact[3]) {
                // horizontal
                boolean check = true;
                for (int x = artifact[0] + 1; x <= artifact[2]; x++) {
                    if (!digs.contains(List.of(x, artifact[1]))) {
                        check = false;
                        break;
                    }
                }
                if (check) counter++;
            } else {
                // diagonal
                if (digs.contains(List.of(artifact[2], artifact[1])) &&
                    digs.contains(List.of(artifact[0], artifact[3])) &&
                    digs.contains(List.of(artifact[2], artifact[3]))
                ) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
