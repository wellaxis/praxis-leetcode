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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nodes;

    public Solution(int nodes) {
        this.nodes = nodes;
    }

    public List<TreeNode> process() {
        return allPossibleFBT(nodes);
    }

    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        if (n == 1) return List.of(new TreeNode(0));
        if (memo.containsKey(n)) return memo.get(n);

        List<TreeNode> ans = new ArrayList<>();

        for (int leftCount = 0; leftCount < n; ++leftCount) {
            final int rightCount = n - 1 - leftCount;
            for (TreeNode left : allPossibleFBT(leftCount))
                for (TreeNode right : allPossibleFBT(rightCount)) {
                    ans.add(new TreeNode(0));
                    ans.get(ans.size() - 1).left = left;
                    ans.get(ans.size() - 1).right = right;
                }
        }

        memo.put(n, ans);

        return ans;
    }
}
