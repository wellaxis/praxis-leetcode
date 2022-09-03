package com.witalis.praxis.leetcode.task.h6.p572;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p572.content.*;
import com.witalis.praxis.leetcode.task.h6.p572.option.*;
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
    id = 572,
    description = "Subtree of Another Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, STRING_MATCHING, HASH_FUNCTION}
)
public class SubtreeOfAnotherTree extends LeetCodeTask<Boolean> {
    public static final int LEN_ORG = 2_000;
    public static final int LEN_SUB = 1_000;
    public static final int VALUE = 10_000;
    private TreeNode root;
    private TreeNode subRoot;

    public static final String INFORMATION = """

        Given the roots of two binary trees root and subRoot, return true if there is a subtree
            of root with the same structure and node values of subRoot and false otherwise.

        A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's
            descendants. The tree tree could also be considered as a subtree of itself.

        Example:
            Input: root = [3,4,5,1,2], subRoot = [4,1,2]
            Output: true""";

    public SubtreeOfAnotherTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate(LEN_ORG);
        this.subRoot = generate(LEN_SUB);

        log.info("Root: {}", root.toString());
        log.info("Sub Root: {}", subRoot.toString());
    }

    private static TreeNode generate(int length) {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, length + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(-VALUE, VALUE + 1));
            }
        }
        var tree = values.toArray(Integer[]::new);
        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 585 ms
    @Override
    protected Boolean original() {
        var original = new Original(root, subRoot);
        return original.process();
    }

    // time = 556 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root, subRoot);
        return practice.process();
    }

    // time = 539 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root, subRoot);
        return solution.process();
    }
}
