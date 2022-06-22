package com.witalis.praxis.leetcode.task.h5.p404.option;

import com.witalis.praxis.leetcode.task.h5.p404.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 404
 * Name: Sum of Left Leaves
 * URL: <a href="https://leetcode.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return sumOfLeftLeaves(root);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if (root == null) return sum;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }
}
