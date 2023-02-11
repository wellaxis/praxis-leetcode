package com.witalis.praxis.leetcode.task.h12.p1129.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1129
 * Name: Shortest Path with Alternating Colors
 * URL: <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/">Shortest Path with Alternating Colors</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] redEdges;
    private int[][] blueEdges;

    public int[] process() {
        return shortestAlternatingPaths(number, redEdges, blueEdges);
    }

    enum Color {
        RED, BLUE;

        public Color invert() {
            return this.equals(RED) ? BLUE : RED;
        }
    }

    record Node (int index, Color color) {}

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        if (n <= 0) return new int[0];

        final int SOURCE = 0;
        final int TARGET = 1;
        final int MOCK = -1;

        final Map<Integer, List<Node>> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList<>());
        }
        boolean startingRedZero = false;
        for (final int[] edge : redEdges) {
            if (edge[SOURCE] == 0) startingRedZero = true;
            nodes.get(edge[SOURCE]).add(new Node(edge[TARGET], Color.RED));
        }
        boolean startingBlueZero = false;
        for (final int[] edge : blueEdges) {
            if (edge[SOURCE] == 0) startingBlueZero = true;
            nodes.get(edge[SOURCE]).add(new Node(edge[TARGET], Color.BLUE));
        }

        final Queue<Node> queue = new ArrayDeque<>();
        if (startingRedZero) queue.offer(new Node(0, Color.BLUE));
        if (startingBlueZero) queue.offer(new Node(0, Color.RED));

        final int[] answer = new int[n];
        Arrays.fill(answer, 1, answer.length, -1);

        int seen = 1;
        for (int iterations = 1; !queue.isEmpty(); iterations++) {
            for (int count = queue.size(); count > 0; count--) {
                final Node node = queue.poll();
                if (node != null) {
                    final List<Node> subNodes = nodes.get(node.index);
                    for (int i = 0; i < subNodes.size(); i++) {
                        final Node subNode = subNodes.get(i);
                        if (subNode.index == MOCK || node.color == subNode.color) continue;
                        if (answer[subNode.index] == -1) {
                            seen++;
                            answer[subNode.index] = iterations;
                            if (seen == n) return answer;
                        }
                        Node next = new Node(subNode.index, node.color.invert());
                        nodes.get(node.index).set(i, new Node(MOCK, next.color));
                        queue.offer(next);
                    }
                }
            }
        }

        return answer;
    }
}
