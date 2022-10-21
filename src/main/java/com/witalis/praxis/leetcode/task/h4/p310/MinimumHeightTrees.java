package com.witalis.praxis.leetcode.task.h4.p310;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p310.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 310,
    description = "Minimum Height Trees",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, TOPOLOGICAL_SORT}
)
public class MinimumHeightTrees extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 20_000;
    public static final int VALUE = 1_000;
    private int nodes;
    private int[][] edges;

    public static final String INFORMATION = """

        Description:
            A tree is an undirected graph in which any two vertices are connected by exactly one path.
                In other words, any connected graph without simple cycles is a tree.

            Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
                indicates that there is an undirected edge between the two nodes ai and bi in the tree,
                you can choose any node of the tree as the root. When you select a node x as the root,
                the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))
                are called minimum height trees (MHTs).

            Return a list of all MHTs' root labels. You can return the answer in any order.

            The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

        Example:
            Input: n = 4, edges = [[1,0],[1,2],[1,3]]
            Output: [1]
            Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.""";

    public MinimumHeightTrees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        List<int[]> list = new LinkedList<>();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        this.nodes = random.nextInt(1, LEN + 1);

        int counter = 1;
        tree: while (!queue.isEmpty()) {
            int parent = queue.poll();
            int children = random.nextInt(1, 6);
            for (int c = 1; c <= children; c++) {
                int child = counter++;
                list.add(new int[] {parent, child});
                if (list.size() == nodes - 1) break tree;
                queue.offer(child);
            }
        }

        this.edges = new int[nodes - 1][];
        for (int i = 0; i < list.size(); i++) {
            edges[i] = list.get(i);
        }

        StringBuilder builder = new StringBuilder();
        for (int[] edge : edges) {
            builder.append(Arrays.toString(edge)).append(",");
        }

        log.info("Nodes are {}", nodes);
        log.info("Edges are {}", builder.substring(0, builder.length() - 1));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 79678293 ms, time limit exceeded
    @Override
    protected List<Integer> original() {
        var original = new Original(nodes, edges);
        return original.process();
    }

    // time = 25465 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(nodes, edges);
        return practice.process();
    }

    // time = 7947 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(nodes, edges);
        return solution.process();
    }
}
