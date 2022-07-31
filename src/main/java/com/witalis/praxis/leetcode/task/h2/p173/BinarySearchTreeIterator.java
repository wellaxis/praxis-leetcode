package com.witalis.praxis.leetcode.task.h2.p173;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p173.content.*;
import com.witalis.praxis.leetcode.task.h2.p173.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 173,
    description = "Binary Search Tree Iterator",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STACK, TREE, DESIGN, BINARY_SEARCH_TREE, BINARY_SEARCH, ITERATOR}
)
public class BinarySearchTreeIterator extends LeetCodeTask<List<String>> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;
    private TreeNode root;
    private List<String> operations;

    public static final String INFORMATION = """

        Implement the BSTIterator class that represents an iterator
            over the in-order traversal of a binary search tree (BST):
            * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
              The root of the BST is given as part of the constructor.
              The pointer should be initialized to a non-existent number smaller than any element in the BST.
            * boolean hasNext() Returns true if there exists a number in the traversal
              to the right of the pointer, otherwise returns false.
            * int next() Moves the pointer to the right, then returns the number at the pointer.

        Notice that by initializing the pointer to a non-existent smallest number,
            the first call to next() will return the smallest element in the BST.

        You may assume that next() calls will always be valid.
            That is, there will be at least a next number in the in-order traversal when next() is called.

        Example:
            Input
                ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
                [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
            Output
                [null, 3, 7, true, 9, true, 15, true, 20, false]
            Explanation
                BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
                bSTIterator.next();    // return 3
                bSTIterator.next();    // return 7
                bSTIterator.hasNext(); // return True
                bSTIterator.next();    // return 9
                bSTIterator.hasNext(); // return True
                bSTIterator.next();    // return 15
                bSTIterator.hasNext(); // return True
                bSTIterator.next();    // return 20
                bSTIterator.hasNext(); // return False""";

    public BinarySearchTreeIterator(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        // tree
        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextInt(0, VALUE + 1));
        }
        var tree = values.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        this.root = TreeNode.initTree(tree);

        log.info("Root: {}", root.toString());

        // operations
        operations = new ArrayList<>();
        operations.add("BSTIterator");
        int size = random.nextInt(1, LEN + 1);
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                operations.add("next");
            } else {
                operations.add("hasNext");
            }
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7009 ms
    @Override
    protected List<String> original() {
        var original = new Original(root, operations);
        return original.process();
    }

    // time = 1931 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(root, operations);
        return practice.process();
    }

    // time = 1867 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(root, operations);
        return solution.process();
    }
}
