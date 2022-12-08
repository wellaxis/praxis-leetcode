package com.witalis.praxis.leetcode.task.h9.p872;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p872.content.*;
import com.witalis.praxis.leetcode.task.h9.p872.option.*;
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
    id = 872,
    description = "Leaf-Similar Trees",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class LeafSimilarTrees extends LeetCodeTask<Boolean> {
    public static final int LEN = 200;
    public static final int VALUE = 200;
    private TreeNode root1;
    private TreeNode root2;

    public static final String INFORMATION = """

        Description:
            Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

            For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

            Two binary trees are considered leaf-similar if their leaf value sequence is the same.

            Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

        Example:
            Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
            Output: true""";

    public LeafSimilarTrees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root1 = generate();
        this.root2 = generate();

        log.info("Root #1 is {}", root1.toString());
        log.info("Root #2 is {}", root2.toString());
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

    // time = 3170 ms
    @Override
    protected Boolean original() {
        var original = new Original(root1, root2);
        return original.process();
    }

    // time = 1791 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root1, root2);
        return practice.process();
    }

    // time = 1611 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root1, root2);
        return solution.process();
    }
}
