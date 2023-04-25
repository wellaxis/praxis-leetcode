package com.witalis.praxis.leetcode.task.h24.p2336;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2336.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2336,
    description = "Smallest Number in Infinite Set",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, DESIGN, HEAP}
)
public class SmallestNumberInInfiniteSet extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Description:
            You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

            Implement the SmallestInfiniteSet class:
                * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
                * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
                * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.

        Example:
            Input
                ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
                [[], [2], [], [], [], [1], [], [], []]
            Output
                [null, null, 1, 2, 3, null, 1, 4, 5]
            Explanation
                SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
                smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
                smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
                smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
                smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
                smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
                smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and is the smallest number, and remove it from the set.
                smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
                smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.""";

    public SmallestNumberInInfiniteSet(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.operations = new ArrayList<>(len);

        operations.add(new AbstractMap.SimpleEntry<>("SmallestInfiniteSet", null));
        for (int i = 1; i < len; i++) {
            int key = random.nextInt(0, VALUE + 1);
            int operation = random.nextInt(0, 2);
            switch (operation) {
                case 0 -> operations.add(new AbstractMap.SimpleEntry<>("addBack", key));
                case 1 -> operations.add(new AbstractMap.SimpleEntry<>("popSmallest", null));
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("SmallestInfiniteSet is {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5512 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 4508 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 6692 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
