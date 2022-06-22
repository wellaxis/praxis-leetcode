package com.witalis.praxis.leetcode.task.h5.p404;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p404.content.*;
import com.witalis.praxis.leetcode.task.h5.p404.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 404,
    description = "Sum of Left Leaves",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class SumOfLeftLeaves extends LeetCodeTask<Integer> {
    public static final int LEN = 1000;
    public static final int VALUE = 1000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, return the sum of all left leaves.

        A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

        Example:
            Input: root = [3,9,20,null,null,15,7]
            Output: 24
            Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.""";

    public SumOfLeftLeaves(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

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
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 607 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 782 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 482 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
