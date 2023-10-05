package com.witalis.praxis.leetcode.task.h11.p1022;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1022.content.*;
import com.witalis.praxis.leetcode.task.h11.p1022.option.*;
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
    id = 1022,
    description = "Sum of Root To Leaf Binary Numbers",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, DEPTH_FIRST_SEARCH, BINARY_TREE}
)
public class SumOfRootToLeafBinaryNumbers extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            You are given the root of a binary tree where each node has a value 0 or 1.
                Each root-to-leaf path represents a binary number starting with the most significant bit.

            * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

            For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
                Return the sum of these numbers.

            The test cases are generated so that the answer fits in a 32-bits integer.

        Example:
            Input: root = [1,0,1,0,1,0,1]
            Output: 22
            Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22""";

    public SumOfRootToLeafBinaryNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate();

        log.info("Root: {}", root.toString());
    }

    private static TreeNode generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextBoolean() ? 1 : 0);
        }
        Integer[] tree = values.toArray(Integer[]::new);
        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3034 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 2548 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1068 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
