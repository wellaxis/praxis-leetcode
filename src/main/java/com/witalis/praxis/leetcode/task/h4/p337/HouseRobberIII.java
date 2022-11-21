package com.witalis.praxis.leetcode.task.h4.p337;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p337.content.*;
import com.witalis.praxis.leetcode.task.h4.p337.option.*;
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
    id = 337,
    description = "House Robber III",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class HouseRobberIII extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            The thief has found himself a new place for his thievery again.
                There is only one entrance to this area, called root.

            Besides the root, each house has one and only one parent house.
                After a tour, the smart thief realized that all houses in this place form a binary tree.
                It will automatically contact the police if two directly-linked houses were broken into on the same night.

            Given the root of the binary tree,
                return the maximum amount of money the thief can rob without alerting the police.

        Example:
            Input: root = [3,2,3,null,3,null,1]
            Output: 7
            Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.""";

    public HouseRobberIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 10) != 0) {
                values.add(i, random.nextInt(0, VALUE + 1));
            } else {
                values.add(i, null);
            }
        }
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("INIT: tree {}", Arrays.toString(tree));
        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4336 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 3720 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 2473 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
