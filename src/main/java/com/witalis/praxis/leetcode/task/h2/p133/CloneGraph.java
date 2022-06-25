package com.witalis.praxis.leetcode.task.h2.p133;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p133.content.*;
import com.witalis.praxis.leetcode.task.h2.p133.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 133,
    description = "Clone Graph",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, GRAPH}
)
public class CloneGraph extends LeetCodeTask<Node> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private Node node;

    public static final String INFORMATION = """

        Given a reference of a node in a connected undirected graph.

        Return a deep copy (clone) of the graph.

        Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
                                               
        class Node {
            public int val;
            public List<Node> neighbors;
        }

        Test case format:
        For simplicity, each node's value is the same as the node's index (1-indexed).
            For example, the first node with val == 1, the second node with val == 2, and so on.
            The graph is represented in the test case using an adjacency list.

        An adjacency list is a collection of unordered lists used to represent a finite graph.
            Each list describes the set of neighbors of a node in the graph.

        The given node will always be the first node with val = 1.
            You must return the copy of the given node as a reference to the cloned graph.

        Example:
            Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
            Output: [[2,4],[1,3],[2,4],[1,3]]
            Explanation: There are 4 nodes in the graph.
                1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
                3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).""";

    public CloneGraph(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        List<List<Integer>> neighbors = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            neighbors.add(i, new ArrayList<>(List.of((i == len - 1) ? 0 : i + 1)));
        }

        List<Integer> elements = new ArrayList<>(IntStream.range(0, len).boxed().toList());
        Collections.shuffle(elements);

        for (int index: elements) {
            int size = random.nextInt(0, len);

            neighbors.get(index).addAll(
                new ArrayList<>(
                    random.ints(size, 0, len)
                        .filter(num -> num != index)
                        .filter(num -> num != index + 1)
                        .filter(num -> !neighbors.get(num).contains(num))
                        .filter(num -> !neighbors.get(num).contains(index))
                        .distinct()
                        .sorted()
                        .boxed()
                        .toList()
                )
            );
        }

        this.node = Node.initGraph(neighbors);
        log.info("Node: {}", node.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 610 ms
    @Override
    protected Node original() {
        var original = new Original(node);
        return original.process();
    }

    // time = 526 ms
    @Override
    protected Node practice() {
        var practice = new Practice(node);
        return practice.process();
    }

    // time = 586 ms
    @Override
    protected Node solution() {
        var solution = new Solution(node);
        return solution.process();
    }
}
