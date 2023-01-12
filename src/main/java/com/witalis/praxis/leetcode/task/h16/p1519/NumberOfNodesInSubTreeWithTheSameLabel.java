package com.witalis.praxis.leetcode.task.h16.p1519;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1519.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1519,
    description = "Number of Nodes in the Sub-Tree With the Same Label",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, COUNTING}
)
public class NumberOfNodesInSubTreeWithTheSameLabel extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;

    private int number;
    private int[][] edges;
    private String labels;

    public static final String INFORMATION = """

        Description:
            You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes
                numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0,
                and each node of the tree has a label which is a lower-case character given in the string labels
                (i.e. The node with the number i has the label labels[i]).

            The edges array is given on the form edges[i] = [ai, bi],
                which means there is an edge between nodes ai and bi in the tree.

            Return an array of size n where ans[i] is the number of nodes in the subtree
                of the ith node which have the same label as node i.

            A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

        Example:
            Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
            Output: [4,2,1,1]
            Explanation:
                The sub-tree of node 2 contains only node 2, so the answer is 1.
                The sub-tree of node 3 contains only node 3, so the answer is 1.
                The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
                The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus the answer is 4.""";

    public NumberOfNodesInSubTreeWithTheSameLabel(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.labels = builder.toString();

        this.edges = new int[number - 1][2];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(count);
        while (!queue.isEmpty() && count < number - 1) {
            int parent = queue.poll();
            int mode = random.nextInt(1, 5);
            for (int m = 0; m < mode; m++) {
                if (count < number - 1) {
                    edges[count] = new int[] {parent, ++count};
                    queue.offer(count);
                }
            }
        }

        log.info("Number N: {}", number);
        log.info("Edges: {}", Arrays.deepToString(edges));
        log.info("Labels: {}", labels);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 67561 ms
    @Override
    protected int[] original() {
        var original = new Original(number, edges, labels);
        return original.process();
    }

    // time = 75039 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(number, edges, labels);
        return practice.process();
    }

    // time = 46444 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(number, edges, labels);
        return solution.process();
    }
}
