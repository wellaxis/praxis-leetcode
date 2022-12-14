package com.witalis.praxis.leetcode.task.h23.p2201;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2201.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2201,
    description = "Count Artifacts That Can Be Extracted",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, SIMULATION}
)
public class CountArtifactsThatCanBeExtracted extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private int dimension;
    private int[][] artifacts;
    private int[][] dig;

    public static final String INFORMATION = """

        Description:
            There is an n x n 0-indexed grid with some artifacts buried in it.
                You are given the integer n and a 0-indexed 2D integer array artifacts
                describing the positions of the rectangular artifacts where
                artifacts[i] = [r1i, c1i, r2i, c2i] denotes that the ith artifact is buried in the subgrid where:
                * (r1i, c1i) is the coordinate of the top-left cell of the ith artifact and
                * (r2i, c2i) is the coordinate of the bottom-right cell of the ith artifact.

            You will excavate some cells of the grid and remove all the mud from them.
                If the cell has a part of an artifact buried underneath, it will be uncovered.
                If all the parts of an artifact are uncovered, you can extract it.

            Given a 0-indexed 2D integer array dig where dig[i] = [ri, ci] indicates
                that you will excavate the cell (ri, ci), return the number of artifacts that you can extract.

            The test cases are generated such that:
                * No two artifacts overlap.
                * Each artifact only covers at most 4 cells.
                * The entries of dig are unique.

        Example:
            Input: n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1]]
            Output: 1
            Explanation:
                The different colors represent different artifacts. Excavated cells are labeled with a 'D' in the grid.
                There is 1 artifact that can be extracted, namely the red artifact.
                The blue artifact has one part in cell (1,1) which remains uncovered, so we cannot extract it.
                Thus, we return 1.""";

    public CountArtifactsThatCanBeExtracted(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.dimension = random.nextInt(1, LEN + 1);

        Set<String> hidden = new HashSet<>();
        List<int[]> arts = new ArrayList<>();
        for (int i = 0; i < dimension * dimension; i++) {
            int row = random.nextInt(0, dimension);
            int col = random.nextInt(0, dimension);
            switch (random.nextInt(0, 4)) {
                case 0 -> {
                    if (!hidden.contains("" + row + "," + col)) {
                        arts.add(new int[]{row, col, row, col});
                        hidden.add("" + row + "," + col);
                    }
                }
                case 1 -> {
                    if (col < dimension - 1 && !hidden.contains("" + row + "," + col) && !hidden.contains("" + row + "," + (col + 1))) {
                        arts.add(new int[]{row, col, row, col + 1});
                        hidden.add("" + row + "," + col);
                        hidden.add("" + row + "," + (col + 1));
                    }
                }
                case 2 -> {
                    if (row < dimension - 1 && !hidden.contains("" + row + "," + col) && !hidden.contains("" + (row + 1) + "," + col)) {
                        arts.add(new int[]{row, col, row + 1, col});
                        hidden.add("" + row + "," + col);
                        hidden.add("" + (row + 1) + "," + col);
                    }
                }
                case 3 -> {
                    if (col < dimension - 1 && row < dimension - 1 &&
                        !hidden.contains("" + row + "," + col) && !hidden.contains("" + row + "," + (col + 1)) &&
                        !hidden.contains("" + (row + 1) + "," + col) && !hidden.contains("" + (row + 1) + "," + (col + 1))
                    ) {
                        arts.add(new int[]{row, col, row + 1, col + 1});
                        hidden.add("" + row + "," + col);
                        hidden.add("" + (row + 1) + "," + col);
                        hidden.add("" + row + "," + (col + 1));
                        hidden.add("" + (row + 1) + "," + (col + 1));
                    }
                }
                default -> throw new IllegalArgumentException("Dimension is incorrect");
            }
        }
        this.artifacts = arts.toArray(new int[0][]);

        Set<int[]> digs = new HashSet<>();
        for (int i = 0; i < dimension * dimension; i++) {
            int row = random.nextInt(0, dimension);
            int col = random.nextInt(0, dimension);
            digs.add(new int[] {row, col});
        }
        this.dig = digs.toArray(new int[0][]);

        log.info("Dimension: {}", dimension);
        log.info("Artifacts: {}", Arrays.deepToString(artifacts));
        log.info("Dig: {}", Arrays.deepToString(dig));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 388749 ms
    @Override
    protected Integer original() {
        var original = new Original(dimension, artifacts, dig);
        return original.process();
    }

    // time = 304591 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(dimension, artifacts, dig);
        return practice.process();
    }

    // time = 13955 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(dimension, artifacts, dig);
        return solution.process();
    }
}
