package com.witalis.praxis.leetcode.task.h5.p427;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p427.content.*;
import com.witalis.praxis.leetcode.task.h5.p427.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 427,
    description = "Construct Quad Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DIVIDE_AND_CONQUER, TREE, MATRIX}
)
public class ConstructQuadTree extends LeetCodeTask<Node> {
    public static final int POW = 6;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.

            Return the root of the Quad-Tree representing the grid.

            Notice that you can assign the value of a node to True or False when isLeaf is False,
                and both are accepted in the answer.

            A Quad-Tree is a tree data structure in which each internal node has exactly four children.
                Besides, each node has two attributes:
                * val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
                * isLeaf: True if the node is leaf node on the tree or False if the node has the four children.

            class Node {
                public boolean val;
                public boolean isLeaf;
                public Node topLeft;
                public Node topRight;
                public Node bottomLeft;
                public Node bottomRight;
            }

            We can construct a Quad-Tree from a two-dimensional area using the following steps:
                * If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True
                  and set val to the value of the grid and set the four children to Null and stop.
                * If the current grid has different values, set isLeaf to False
                  and set val to any value and divide the current grid into four sub-grids as shown in the photo.

            Recurse for each of the children with the proper sub-grid.

            If you want to know more about the Quad-Tree, you can refer to the wiki.

            Quad-Tree format:
                The output represents the serialized format of a Quad-Tree using level order traversal,
                where null signifies a path terminator where no node exists below.

                It is very similar to the serialization of the binary tree.
                The only difference is that the node is represented as a list [isLeaf, val].

                If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val]
                and if the value of isLeaf or val is False we represent it as 0.

        Example:
            Input:
                grid =
                [
                    [1,1,1,1,0,0,0,0],
                    [1,1,1,1,0,0,0,0],
                    [1,1,1,1,1,1,1,1],
                    [1,1,1,1,1,1,1,1],
                    [1,1,1,1,0,0,0,0],
                    [1,1,1,1,0,0,0,0],
                    [1,1,1,1,0,0,0,0],
                    [1,1,1,1,0,0,0,0]
                ]
            Output:
                [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
            Explanation:
                All values in the grid are not the same. We divide the grid into four sub-grids.
                The topLeft, bottomLeft and bottomRight each has the same value.
                The topRight have different values so we divide it into 4 sub-grids where each has the same value.""";

    public ConstructQuadTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int pow = random.nextInt(0, POW + 1);
        final int size = (int) Math.pow(2, pow);

        this.grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = random.nextBoolean() ? 1 : 0;
            }
        }

        var builder = new StringBuilder().append('\n');
        for (int[] array : grid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Grid [{} x {}]: {}", size, size, builder);
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 887 ms
    @Override
    protected Node original() {
        var original = new Original(grid);
        return original.process();
    }

    // time = 716 ms
    @Override
    protected Node practice() {
        var practice = new Practice(grid);
        return practice.process();
    }

    // time = 481 ms
    @Override
    protected Node solution() {
        var solution = new Solution(grid);
        return solution.process();
    }
}
