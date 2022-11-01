package com.witalis.praxis.leetcode.task.h8.p705;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p705.option.*;
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
    id = 705,
    description = "Design HashSet",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, LINKED_LIST, DESIGN, HASH_FUNCTION}
)
public class DesignHashSet extends LeetCodeTask<List<String>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Design a HashSet without using any built-in hash table libraries.

        Implement MyHashSet class:
            * void add(key) Inserts the value key into the HashSet.
            * bool contains(key) Returns whether the value key exists in the HashSet or not.
            * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

        Example:
            Input:
                ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
                [[], [1], [2], [1], [3], [2], [2], [2], [2]]
            Output:
                [null, null, null, true, false, null, true, null, false]
            Explanation:
                MyHashSet myHashSet = new MyHashSet();
                myHashSet.add(1);      // set = [1]
                myHashSet.add(2);      // set = [1, 2]
                myHashSet.contains(1); // return True
                myHashSet.contains(3); // return False, (not found)
                myHashSet.add(2);      // set = [1, 2]
                myHashSet.contains(2); // return True
                myHashSet.remove(2);   // set = [1]
                myHashSet.contains(2); // return False, (already removed)""";

    public DesignHashSet(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    @SuppressWarnings("unchecked")
    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.operations = new ArrayList<>(len);

        operations.add(new AbstractMap.SimpleEntry<>("MyHashSet", null));
        for (int i = 1; i < len; i++) {
            int key = random.nextInt(0, VALUE + 1);
            int operation = random.nextInt(0, 3);
            switch (operation) {
                case 0 -> operations.add(new AbstractMap.SimpleEntry<>("add", key));
                case 1 -> operations.add(new AbstractMap.SimpleEntry<>("remove", key));
                case 2 -> operations.add(new AbstractMap.SimpleEntry<>("contains", key));
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("HashSet is {}", operations.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5512 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 4508 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 6692 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
