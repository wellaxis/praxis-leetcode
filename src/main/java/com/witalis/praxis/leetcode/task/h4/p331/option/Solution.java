package com.witalis.praxis.leetcode.task.h4.p331.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 331
 * Name: Verify Preorder Serialization of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/">Verify Preorder Serialization of a Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String preorder;

    public Boolean process() {
        return isValidSerialization(preorder);
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }

        return diff == 0;
    }
}
