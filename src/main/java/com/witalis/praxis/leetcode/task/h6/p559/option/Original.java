package com.witalis.praxis.leetcode.task.h6.p559.option;

import com.witalis.praxis.leetcode.task.h6.p559.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 559
 * Name: Maximum Depth of N-ary Tree
 * URL: <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of N-ary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Node root;

    public Integer process() {
        return maxDepth(root);
    }

    public int maxDepth(Node root) {
        int[] maxDepth = new int[] {0};
        recursiveDepth(root, maxDepth, 1);

        return maxDepth[0];
    }

    private void recursiveDepth(Node node, int[] maxDepth, int depth) {
        if (node == null) return;

        if (maxDepth[0] < depth) maxDepth[0] = depth;

        for (Node child : node.children) {
            recursiveDepth(child, maxDepth, depth + 1);
        }
    }
}
