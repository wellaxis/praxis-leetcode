package com.witalis.praxis.leetcode.task.h9.p872.option;

import com.witalis.praxis.leetcode.task.h9.p872.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 872
 * Name: Leaf-Similar Trees
 * URL: <a href="https://leetcode.com/problems/leaf-similar-trees/">Leaf-Similar Trees</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root1;
    private TreeNode root2;

    public Practice(TreeNode root1, TreeNode root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public Boolean process() {
        return leafSimilar(root1, root2);
    }

    private List<Integer> leaves1 = new ArrayList<>();
    private List<Integer> leaves2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        if (leaves1.size() != leaves2.size()) return false;
        for (int i = 0; i < leaves1.size(); i++)
            if (leaves1.get(i).intValue() != leaves2.get(i).intValue()) return false;

        return true;
    }

    private static void dfs(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            if (node.left != null) dfs(node.left, leaves);
            if (node.right != null) dfs(node.right, leaves);
        }
    }
}
