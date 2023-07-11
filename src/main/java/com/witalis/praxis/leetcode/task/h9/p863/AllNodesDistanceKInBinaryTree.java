package com.witalis.praxis.leetcode.task.h9.p863;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p863.content.*;
import com.witalis.praxis.leetcode.task.h9.p863.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 863,
    description = "All Nodes Distance K in Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class AllNodesDistanceKInBinaryTree extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 500;
    public static final int VALUE = 500;
    public static final int PATH = 1_000;

    private TreeNode root;
    private TreeNode target;
    private int distance;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, the value of a target node target, and an integer k,
                return an array of the values of all nodes that have a distance k from the target node.

            You can return the answer in any order.

        Example:
            Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
            Output: [7,4,1]
            Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.""";

    public AllNodesDistanceKInBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        Set<Integer> vals = new HashSet<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                int value = random.nextInt(0, VALUE + 1);
                while (vals.contains(value))
                    value = random.nextInt(0, VALUE + 1);
                values.add(value);
                vals.add(value);
            }
        }
        Integer[] tree = values.toArray(Integer[]::new);

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        Collections.shuffle(values);
        int index = 0;
        this.target = TreeNode.findNode(root, values.get(index++));
        while (target == null)
            target = TreeNode.findNode(root, values.get(index++));

        this.distance = random.nextInt(0, PATH + 1);

        log.info("Root: {}", root.toString());
        log.info("Target: {}", target.toString());
        log.info("Distance K: {}", distance);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1233 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root, target, distance);
        return original.process();
    }

    // time = 1111 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root, target, distance);
        return practice.process();
    }

    // time = 605 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root, target, distance);
        return solution.process();
    }
}
