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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;
    private TreeNode target;
    private int distance;

    public Original(TreeNode root, TreeNode target, int distance) {
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null || k < 0) return Collections.emptyList();

        this.targetValue = target.val;
        traverse(root, null);

        final List<Integer> nodes = new ArrayList<>();
        dfs(targetRoute, nodes, 0, k, new HashSet<>());

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

    private void dfs(RouteNode node, List<Integer> nodes, int path, int distance, Set<Integer> seen) {
        if (node == null || seen.contains(node.value)) return;
        if (path == distance) {
            nodes.add(node.value);
        } else {
            seen.add(node.value);
            dfs(node.parent, nodes, path + 1, distance, seen);
            dfs(node.left, nodes, path + 1, distance, seen);
            dfs(node.right, nodes, path + 1, distance, seen);
            seen.remove(node.value);
        }
    }
}
