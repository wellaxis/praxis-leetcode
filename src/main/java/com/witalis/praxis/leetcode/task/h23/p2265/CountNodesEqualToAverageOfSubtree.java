package com.witalis.praxis.leetcode.task.h23.p2265;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2265.content.*;
import com.witalis.praxis.leetcode.task.h23.p2265.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2265,
    description = "Count Nodes Equal to Average of Subtree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class CountNodesEqualToAverageOfSubtree extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, return the number of nodes where the value of the node
                is equal to the average of the values in its subtree.

            Note:
                * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
                * A subtree of root is a tree consisting of root and all of its descendants.

        Example:
            Input: root = [4,8,5,0,1,null,6]
            Output: 5
            Explanation:
                For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
                For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
                For the node with value 0: The average of its subtree is 0 / 1 = 0.
                For the node with value 1: The average of its subtree is 1 / 1 = 1.
                For the node with value 6: The average of its subtree is 6 / 1 = 6.""";

    public CountNodesEqualToAverageOfSubtree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate();

        log.info("Root is {}", root.toString());
    }

    private static TreeNode generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(0, VALUE + 1));
            }
        }
        Integer[] tree = values.toArray(Integer[]::new);
        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 984 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 597 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 572 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
