package com.witalis.praxis.leetcode.task.h10.p965;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p965.content.*;
import com.witalis.praxis.leetcode.task.h10.p965.option.*;
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
    id = 965,
    description = "Univalued Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class UnivaluedBinaryTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            A binary tree is uni-valued if every node in the tree has the same value.

            Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

        Example:
            Input: root = [1,2,3,4,5,null,7]
            Output: false
            Explanation: The node with value 7 isn't as far left as possible.""";

    public UnivaluedBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 10 && random.nextInt(0, 10) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(0, VALUE + 1));
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

    // time = 535 ms
    @Override
    protected Boolean original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 503 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 483 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
