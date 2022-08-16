package com.witalis.praxis.leetcode.task.h2.p199;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p199.content.*;
import com.witalis.praxis.leetcode.task.h2.p199.option.*;
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
    id = 199,
    description = "Binary Tree Right Side View",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class BinaryTreeRightSideView extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, imagine yourself standing on the right side of it,
            return the values of the nodes you can see ordered from top to bottom.

        Example:
            Input: root = [1,2,3,null,5,null,4]
            Output: [1,3,4]""";

    public BinaryTreeRightSideView(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 10) != 0) {
                values.add(i, random.nextInt(-VALUE, VALUE + 1));
            } else {
                values.add(i, null);
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

    // time = 1639 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1024 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1006 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
