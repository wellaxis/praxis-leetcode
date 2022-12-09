package com.witalis.praxis.leetcode.task.h11.p1026;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1026.content.*;
import com.witalis.praxis.leetcode.task.h11.p1026.option.*;
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
    id = 1026,
    description = "Maximum Difference Between Node and Ancestor",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class MaximumDifferenceBetweenNodeAndAncestor extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 100_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, find the maximum value v for which there exist
                different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

            A node a is an ancestor of b if either:
                any child of a is equal to b or any child of a is an ancestor of b.

        Example:
            Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
            Output: 7
            Explanation: We have various ancestor-node differences, some of which are given below :
                |8 - 3| = 5
                |3 - 7| = 4
                |8 - 1| = 7
                |10 - 13| = 3
                Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.""";

    public MaximumDifferenceBetweenNodeAndAncestor(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate();

        log.info("Root is {}", root.toString());
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

    // time = 949 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 894 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 879 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
