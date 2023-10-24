package com.witalis.praxis.leetcode.task.h6.p515.option;

import com.witalis.praxis.leetcode.task.h6.p515.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 515
 * Name: Find Largest Value in Each Tree Row
 * URL: <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">Find Largest Value in Each Tree Row</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public List<Integer> process() {
        return largestValues(root);
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> values = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                max = Math.max(max, node.val);
            }

            values.add(max);
        }

        return values;
    }
}
