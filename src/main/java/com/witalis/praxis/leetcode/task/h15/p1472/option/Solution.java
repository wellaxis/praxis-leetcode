package com.witalis.praxis.leetcode.task.h15.p1472.option;

import com.witalis.praxis.leetcode.task.h15.p1472.content.IBrowserHistory;
import com.witalis.praxis.leetcode.task.h15.p1472.content.BrowserHistoryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 1472
 * Name: Design Browser History
 * URL: <a href="https://leetcode.com/problems/design-browser-history/">Design Browser History</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class BrowserHistory implements IBrowserHistory {
        Node root;

        private static class Node {
            String val;
            Node next;
            Node prev;

            public Node(String value) {
                this.val = value;
                this.prev = null;
                this.next = null;
            }
        }

        public BrowserHistory(String homepage) {
            this.root = new Node(homepage);
        }

        @Override
        public void visit(String url) {
            Node node = new Node(url);
            root.next = node;
            node.prev = root;
            root = node;
        }

        @Override
        public String back(int steps) {
            Node current = root;
            while (steps-- > 0 && current.prev != null) {
                current = current.prev;
            }
            root = current;

            return current.val;
        }

        @Override
        public String forward(int steps) {
            Node current = root;
            while (steps-- > 0 && current.next != null) {
                current = current.next;
            }
            root = current;

            return current.val;
        }
    }

    public List<String> process() {
        return BrowserHistoryHandler.process(operations, new BrowserHistory(operations.get(0).getValue()));
    }
}
