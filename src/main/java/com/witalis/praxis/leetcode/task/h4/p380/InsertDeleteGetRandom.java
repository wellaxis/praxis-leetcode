package com.witalis.praxis.leetcode.task.h4.p380;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p380.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 380,
    description = "Insert Delete GetRandom",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, MATH, DESIGN, RANDOMIZED}
)
public class InsertDeleteGetRandom extends LeetCodeTask<List<String>> {
    public static final int LEN = 200_000;

    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Description:
            Implement the RandomizedSet class:
            * RandomizedSet() Initializes the RandomizedSet object.
            * bool insert(int val) Inserts an item val into the set if not present.
              Returns true if the item was not present, false otherwise.
            * bool remove(int val) Removes an item val from the set if present.
              Returns true if the item was present, false otherwise.
            * int getRandom() Returns a random element from the current set of elements
              (it's guaranteed that at least one element exists when this method is called).
              Each element must have the same probability of being returned.

            You must implement the functions of the class such that each function works in average O(1) time complexity.

        Example:
            Input
                ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
                [[], [1], [2], [2], [], [1], [2], []]
            Output
                [null, true, false, true, 2, true, false, 2]
            Explanation
                RandomizedSet randomizedSet = new RandomizedSet();
                randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
                randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
                randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
                randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
                randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
                randomizedSet.insert(2); // 2 was already in the set, so return false.
                randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.""";

    public InsertDeleteGetRandom(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("RandomizedSet", null));

        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            int operation = random.nextInt(0, 3);
            switch (operation) {
                case 0 -> {
                    int value = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    operations.add(new AbstractMap.SimpleEntry<>("insert", value));
                }
                case 1 -> {
                    int value = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    operations.add(new AbstractMap.SimpleEntry<>("remove", value));
                }
                case 2 -> {
                    operations.add(new AbstractMap.SimpleEntry<>("getRandom", null));
                }
                default -> throw new IllegalArgumentException("Unexpected operation");
            }
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1635125 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 78482 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 29152 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
