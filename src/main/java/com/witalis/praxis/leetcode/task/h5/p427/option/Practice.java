package com.witalis.praxis.leetcode.task.h5.p427.option;

import com.witalis.praxis.leetcode.task.h5.p427.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 427
 * Name: Construct Quad Tree
 * URL: <a href="https://leetcode.com/problems/construct-quad-tree/description/">Construct Quad Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Node process() {
        return construct(grid);
    }

    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node helper(int[][] grid, int x, int y, int len) {
        if (len == 1) return new Node(grid[x][y] != 0, true, null, null, null, null);

        final Node topLeft = helper(grid, x, y, len / 2);
        final Node topRight = helper(grid, x, y + len / 2, len / 2);
        final Node bottomLeft = helper(grid, x + len / 2, y, len / 2);
        final Node bottomRight = helper(grid, x + len / 2, y + len / 2, len / 2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val
        ) {
            return new Node(topLeft.val, true);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
