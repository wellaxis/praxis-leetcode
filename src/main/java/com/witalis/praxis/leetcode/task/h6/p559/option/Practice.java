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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Node root;

    public Practice(Node root) {
        this.root = root;
    }

    public Integer process() {
        return maxDepth(root);
    }

    private int maxDepth = 0;

    public int maxDepth(Node root) {
        recursiveDepth(root, 1);

        return maxDepth;
    }

    private void recursiveDepth(Node node, int depth) {
        if (node == null) return;

        if (maxDepth < depth) maxDepth = depth;

        for (Node child : node.children) {
            recursiveDepth(child, depth + 1);
        }
    }
}
