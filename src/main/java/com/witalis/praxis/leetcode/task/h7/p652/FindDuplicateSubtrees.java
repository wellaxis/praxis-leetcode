package com.witalis.praxis.leetcode.task.h7.p652;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p652.content.*;
import com.witalis.praxis.leetcode.task.h7.p652.option.*;
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
    id = 652,
    description = "Find Duplicate Subtrees",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class FindDuplicateSubtrees extends LeetCodeTask<List<TreeNode>> {
    public static final int LEN = 5_000;
    public static final int VALUE = 200;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, return all duplicate subtrees.

            For each kind of duplicate subtrees, you only need to return the root node of any one of them.

            Two trees are duplicate if they have the same structure with the same node values.

        Example:
            Input: root = [1,2,3,4,null,2,4,null,null,4]
            Output: [[2,4],[4]]""";

    public FindDuplicateSubtrees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 6) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(-VALUE, VALUE + 1));
            }
        }
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1885 ms
    @Override
    protected List<TreeNode> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1768 ms
    @Override
    protected List<TreeNode> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1225 ms
    @Override
    protected List<TreeNode> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
