package com.witalis.praxis.leetcode.task.h6.p589.option;

import com.witalis.praxis.leetcode.task.h6.p589.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 589
 * Name: N-ary Tree Preorder Traversal
 * URL: <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">N-ary Tree Preorder Traversal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Node root;

    public List<Integer> process() {
        return preorder(root);
    }

    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();

        List<Integer> values = new ArrayList<>();

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node parent = stack.pop();
            values.add(parent.val);
            for (int i = parent.children.size() - 1; i >= 0; i--) stack.push(parent.children.get(i));
        }

        return values;
    }
}
