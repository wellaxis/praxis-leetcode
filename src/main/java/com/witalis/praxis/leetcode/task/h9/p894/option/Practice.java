package com.witalis.praxis.leetcode.task.h9.p894.option;

import com.witalis.praxis.leetcode.task.h9.p894.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 894
 * Name: All Possible Full Binary Trees
 * URL: <a href="https://leetcode.com/problems/all-possible-full-binary-trees/">All Possible Full Binary Trees</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int nodes;

    public Practice(int nodes) {
        this.nodes = nodes;
    }

    public List<TreeNode> process() {
        return allPossibleFBT(nodes);
    }

    private Map<Integer, List<TreeNode>> saved = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n <= 0 || n % 2 == 0) return Collections.emptyList();

        if (!saved.containsKey(n)) {
            List<TreeNode> nodes = new ArrayList<>();

            if (n == 1) {
                nodes.add(new TreeNode(0));
            } else {
                for (int i = 1; i < n; i += 2) {
                    List<TreeNode> leftTrees = allPossibleFBT(i);
                    List<TreeNode> rightTrees = allPossibleFBT(n - i - 1);

                    for (TreeNode leftNode : leftTrees) {
                        for (TreeNode rightNode : rightTrees) {
                            nodes.add(new TreeNode(0, leftNode, rightNode));
                        }
                    }
                }
            }

            saved.put(n, nodes);
        }

        return saved.get(n);
    }
}
