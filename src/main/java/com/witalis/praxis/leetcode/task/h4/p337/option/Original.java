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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return rob(root);
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, new HashMap<>());
    }

    private static int dfs(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);

        int value = node.val;

        int left = dfs(node.left, map);
        int right = dfs(node.right, map);

        int[] lefts = new int[2];
        if (node.left != null) {
            lefts[0] = dfs(node.left.left, map);
            lefts[1] = dfs(node.left.right, map);
        }
        int maxLeft = lefts[0] + lefts[1];

        int[] rights = new int[2];
        if (node.right != null) {
            rights[0] = dfs(node.right.left, map);
            rights[1] = dfs(node.right.right, map);
        }
        int maxRight = rights[0] + rights[1];

        int res1 = value + maxLeft + maxRight;
        int res2 = left + Math.max(right, maxRight);
        int res3 = right + Math.max(left, maxLeft);

        map.put(node, Math.max(res1, Math.max(res2, res3)));

        return map.get(node);
    }
}
