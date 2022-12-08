package com.witalis.praxis.leetcode.task.h9.p872.option;

import com.witalis.praxis.leetcode.task.h9.p872.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 872
 * Name: Leaf-Similar Trees
 * URL: <a href="https://leetcode.com/problems/leaf-similar-trees/">Leaf-Similar Trees</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root1;
    private TreeNode root2;

    public Boolean process() {
        return leafSimilar(root1, root2);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        int[] values1 = leaves1.stream().mapToInt(Integer::intValue).toArray();
        int[] values2 = leaves2.stream().mapToInt(Integer::intValue).toArray();

        return Arrays.equals(values1, values2);
    }

    private static void dfs(TreeNode node, List<Integer> leaves) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            } else {
                if (node.left != null) dfs(node.left, leaves);
                if (node.right != null) dfs(node.right, leaves);
            }
        }
    }
}
