package com.witalis.praxis.leetcode.task.h4.p337.option;

import com.witalis.praxis.leetcode.task.h4.p337.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 337
 * Name: House Robber III
 * URL: <a href="https://leetcode.com/problems/house-robber-iii/">House Robber III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Practice(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return rob(root);
    }

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);

        int left = dfs(node.left);
        int right = dfs(node.right);

        int subLeft = (node.left == null) ? 0 : dfs(node.left.left) + dfs(node.left.right);
        int subRight = (node.right == null) ? 0 : dfs(node.right.left) + dfs(node.right.right);

        int res1 = node.val + subLeft + subRight;
        int res2 = left + Math.max(right, subRight);
        int res3 = right + Math.max(left, subLeft);

        map.put(node, Math.max(res1, Math.max(res2, res3)));

        return map.get(node);
    }
}
