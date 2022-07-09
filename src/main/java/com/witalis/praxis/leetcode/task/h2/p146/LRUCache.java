package com.witalis.praxis.leetcode.task.h2.p146;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p146.option.*;
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
    id = 146,
    description = "LRU Cache",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, LINKED_LIST, DESIGN, DOUBLY_LINKED_LIST}
)
public class LRUCache extends LeetCodeTask<List<Integer>> {
    public static final int SIZE = 3_000;
    public static final int KEY = 10_000;
    public static final int VALUE = 100_000;
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

        Implement the LRUCache class:
            * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
            * int get(int key) Return the value of the key if the key exists, otherwise return -1.
            * void put(int key, int value) Update the value of the key if the key exists.
              Otherwise, add the key-value pair to the cache.
              If the number of keys exceeds the capacity from this operation, evict the least recently used key.

        The functions get and put must each run in O(1) average time complexity.

        Example:
            Input
                ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
                [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
            Output
                [null, null, null, 1, null, -1, null, -1, 3, 4]""";

    public LRUCache(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int capacity = random.nextInt(1, SIZE + 1);

        operations = new ArrayList<>(4 * capacity);
        operations.add(new AbstractMap.SimpleEntry<>("LRUCache", capacity));

        for (int i = 1; i < 4 * capacity; i++) {
            int key = random.nextInt(0, KEY + 1);
            if (random.nextBoolean()) {
                operations.add(new AbstractMap.SimpleEntry<>("put", key));
            } else {
                operations.add(new AbstractMap.SimpleEntry<>("get", key));
            }
        }

        log.info("LRUCache is {}", operations.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6487 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 5248 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 5190 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
