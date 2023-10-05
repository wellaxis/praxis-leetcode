package com.witalis.praxis.leetcode.task.h11.p1022.option;

import com.witalis.praxis.leetcode.task.h11.p1022.content.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1022
 * Name: Sum of Root To Leaf Binary Numbers
 * URL: <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/">Sum of Root To Leaf Binary Numbers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Original(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return sumRootToLeaf(root);
    }

    private List<List<Integer>> binaries = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        dfs(root, new ArrayList<>());

        int sum = 0;
        for (List<Integer> binary : binaries) {
            Collections.reverse(binary);
            for (int i = 0, p = 1; i < binary.size(); i++, p *=2)
                sum += binary.get(i) * p;
        }

        return sum;
    }

    private void dfs (TreeNode node, List<Integer> binary) {
        binary.add(node.val);

        if (node.left == null && node.right == null) {
            binaries.add(new ArrayList<>(binary));
        }

        if (node.left != null) dfs(node.left, binary);
        if (node.right != null) dfs(node.right, binary);

        binary.remove(binary.size() - 1);
    }
}
