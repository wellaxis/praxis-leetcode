package com.witalis.praxis.leetcode.task.h24.p2385;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2385.content.*;
import com.witalis.praxis.leetcode.task.h24.p2385.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2385,
    description = "Amount of Time for Binary Tree to Be Infected",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class AmountOfTimeForBinaryTreeToBeInfected extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private TreeNode root;
    private int start;

    public static final String INFORMATION = """

        Description:
            You are given the root of a binary tree with unique values, and an integer start.
                At minute 0, an infection starts from the node with value start.

            Each minute, a node becomes infected if:
                * The node is currently uninfected.
                * The node is adjacent to an infected node.

            Return the number of minutes needed for the entire tree to be infected.

        Example:
            Input: root = [1,5,3,null,4,10,6,9,2], start = 3
            Output: 4
            Explanation: The following nodes are infected during:
                - Minute 0: Node 3
                - Minute 1: Nodes 1, 10 and 6
                - Minute 2: Node 5
                - Minute 3: Node 4
                - Minute 4: Nodes 9 and 2
                It takes 4 minutes for the whole tree to be infected so we return 4.""";

    public AmountOfTimeForBinaryTreeToBeInfected(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate();

        log.info("Root: {}", root.toString());
        log.info("Start: {}", start);
    }

    private TreeNode generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        Set<Integer> uniques = new HashSet<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                int value = random.nextInt(0, VALUE + 1);
                while (uniques.contains(value))
                    value = random.nextInt(0, VALUE + 1);
                values.add(value);
                uniques.add(value);
            }
        }
        Integer[] tree = values.toArray(Integer[]::new);
        this.start = (int) uniques.toArray()[uniques.size() - 1];

        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1388 ms
    @Override
    protected Integer original() {
        var original = new Original(root, start);
        return original.process();
    }

    // time = 1375 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root, start);
        return practice.process();
    }

    // time = 1258 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root, start);
        return solution.process();
    }
}
