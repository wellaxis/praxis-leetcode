package com.witalis.praxis.leetcode.task.h9.p863.option;

import com.witalis.praxis.leetcode.task.h9.p863.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 863
 * Name: All Nodes Distance K in Binary Tree
 * URL: <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/">All Nodes Distance K in Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private TreeNode target;
    private int distance;

    public Practice(TreeNode root, TreeNode target, int distance) {
        this.root = root;
        this.target = target;
        this.distance = distance;
    }

    public List<Integer> process() {
        return distanceK(root, target, distance);
    }

    static class RouteNode {
        private int value;
        private RouteNode parent;
        private RouteNode left;
        private RouteNode right;

        public RouteNode(int value, RouteNode parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private RouteNode targetRoute;
    private int targetValue;
    private List<Integer> nodes;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null || k < 0) return Collections.emptyList();

        this.nodes = new ArrayList<>();
        this.targetValue = target.val;
        traverse(root, null);

        dfs(targetRoute, k, new HashSet<>());

        return nodes;
    }

    private RouteNode traverse(TreeNode treeNode, RouteNode routeParent) {
        if (treeNode == null) return null;

        RouteNode routeNode = new RouteNode(treeNode.val, routeParent);

        routeNode.left = traverse(treeNode.left, routeNode);
        routeNode.right = traverse(treeNode.right, routeNode);

        if (routeNode.value == targetValue)
            targetRoute = routeNode;

        return routeNode;
    }

    private void dfs(RouteNode node, int distance, Set<Integer> seen) {
        if (node == null || seen.contains(node.value)) return;

        if (distance == 0) {
            nodes.add(node.value);
        } else {
            seen.add(node.value);
            dfs(node.parent, distance - 1, seen);
            dfs(node.left, distance - 1, seen);
            dfs(node.right, distance - 1, seen);
            seen.remove(node.value);
        }
    }
}
