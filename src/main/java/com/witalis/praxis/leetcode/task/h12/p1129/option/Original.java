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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] redEdges;
    private int[][] blueEdges;

    public int[] process() {
        return shortestAlternatingPaths(number, redEdges, blueEdges);
    }

    record Node (int index, int color) {
        public static final int RED = 1;
        public static final int BLUE = 2;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        if (n <= 0) return new int[0];

        final Map<Integer, List<Integer>> redNodes = new HashMap<>();
        for (final int[] edges : redEdges) {
            redNodes.putIfAbsent(edges[0], new ArrayList<>());
            redNodes.get(edges[0]).add(edges[1]);
        }

        final Map<Integer, List<Integer>> blueNodes = new HashMap<>();
        for (final int[] edges : blueEdges) {
            blueNodes.putIfAbsent(edges[0], new ArrayList<>());
            blueNodes.get(edges[0]).add(edges[1]);
        }

        final Queue<Node> queue = new ArrayDeque<>();
        if (redNodes.containsKey(0)) queue.offer(new Node(0, Node.BLUE));
        if (blueNodes.containsKey(0)) queue.offer(new Node(0, Node.RED));

        final Set<Node> cache = new HashSet<>();

        final int[] answer = new int[n];
        Arrays.fill(answer, 1, answer.length, -1);

        int seen = 1;
        int iterations = 0;
        while (!queue.isEmpty()) {
            iterations++;
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                assert node != null : "node should be specified";
                List<Integer> subNodes = (node.color == Node.RED) ? blueNodes.get(node.index) : redNodes.get(node.index);
                if (subNodes != null) {
                    for (Integer subNode : subNodes) {
                        if (answer[subNode] == -1) {
                            seen++;
                            answer[subNode] = iterations;
                            if (seen == n) return answer;
                        }
                        Node next = new Node(subNode, (node.color == Node.RED) ? Node.BLUE : Node.RED);
                        if (!cache.contains(next)) queue.offer(next);
                    }
                }
                cache.add(node);
            }
        }

        return answer;
    }
}
