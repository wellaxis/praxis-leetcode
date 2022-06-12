package com.witalis.praxis.leetcode.task.h2.p129;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p129.content.*;
import com.witalis.praxis.leetcode.task.h2.p129.option.*;
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
    id = 129,
    description = "Sum Root to Leaf Numbers",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class SumRootToLeafNumbers extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 10;
    private TreeNode root;

    public static final String INFORMATION = """

        You are given the root of a binary tree containing digits from 0 to 9 only.

        Each root-to-leaf path in the tree represents a number.
            * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.

        Return the total sum of all root-to-leaf numbers.
            Test cases are generated so that the answer will fit in a 32-bit integer.

        A leaf node is a node with no children.

        Example:
            Input: root = [4,9,0,5,1]
            Output: 1026
            Explanation:
                The root-to-leaf path 4->9->5 represents the number 495.
                The root-to-leaf path 4->9->1 represents the number 491.
                The root-to-leaf path 4->0 represents the number 40.
                Therefore, sum = 495 + 491 + 40 = 1026.""";

    public SumRootToLeafNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextInt(0, VALUE));
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

    // time = 919 ms
    @Override
    protected Integer original() {
        var original = new Original(TreeNode.cloneTree(root));
        return original.process();
    }

    // time = 476 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(TreeNode.cloneTree(root));
        return practice.process();
    }

    // time = 478 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(TreeNode.cloneTree(root));
        return solution.process();
    }
}
