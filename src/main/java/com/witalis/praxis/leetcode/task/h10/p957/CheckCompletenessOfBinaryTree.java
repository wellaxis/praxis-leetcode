package com.witalis.praxis.leetcode.task.h10.p957;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p957.content.*;
import com.witalis.praxis.leetcode.task.h10.p957.option.*;
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
    id = 957,
    description = "Check Completeness of a Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, BREADTH_FIRST_SEARCH}
)
public class CheckCompletenessOfBinaryTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, determine if it is a complete binary tree.

            In a complete binary tree, every level, except possibly the last, is completely filled,
                and all nodes in the last level are as far left as possible.
                It can have between 1 and 2^h nodes inclusive at the last level h.

        Example:
            Input: root = [1,2,3,4,5,null,7]
            Output: false
            Explanation: The node with value 7 isn't as far left as possible.""";

    public CheckCompletenessOfBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 50) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(1, VALUE + 1));
            }
        }
        Integer[] tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 553 ms
    @Override
    protected Boolean original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 522 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 479 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
