package com.witalis.praxis.leetcode.task.h6.p590.option;

import com.witalis.praxis.leetcode.task.h6.p590.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 590
 * Name: N-ary Tree Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree Postorder Traversal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Node root;

    public List<Integer> process() {
        return postorder(root);
    }

    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.emptyList();

        List<Integer> values = new ArrayList<>();

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node parent = stack.pop();
            for (int i = 0; i < parent.children.size(); i++) stack.push(parent.children.get(i));
            values.add(parent.val);
        }
        Collections.reverse(values);

        return values;
    }
}
