package com.witalis.praxis.leetcode.task.h8.p706;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p706.option.*;
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
    id = 706,
    description = "Design HashMap",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, LINKED_LIST, DESIGN, HASH_FUNCTION}
)
public class DesignHashMap extends LeetCodeTask<List<String>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;
    private List<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Integer>>> operations;

    public static final String INFORMATION = """

        Description:
            Design a HashMap without using any built-in hash table libraries.

            Implement the MyHashMap class:
            * MyHashMap() initializes the object with an empty map.
            * void put(int key, int value) inserts a (key, value) pair into the HashMap.
              If the key already exists in the map, update the corresponding value.
            * int get(int key) returns the value to which the specified key is mapped,
              or -1 if this map contains no mapping for the key.
            * void remove(key) removes the key and its corresponding value
              if the map contains the mapping for the key.

        Example:
            Input
                ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
                [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
            Output
                [null, null, null, 1, -1, null, 1, null, -1]
            Explanation
                MyHashMap myHashMap = new MyHashMap();
                myHashMap.put(1, 1); // The map is now [[1,1]]
                myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
                myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
                myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
                myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
                myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
                myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
                myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]""";

    public DesignHashMap(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    @SuppressWarnings("unchecked")
    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.operations = new ArrayList<>(len);

        operations.add(new AbstractMap.SimpleEntry<>("MyHashMap", null));
        for (int i = 1; i < len; i++) {
            int key = random.nextInt(0, VALUE + 1);
            int value = random.nextInt(0, VALUE + 1);
            int operation = random.nextInt(0, 3);
            var element = new AbstractMap.SimpleEntry<>(key, value);
            switch (operation) {
                case 0 -> operations.add(new AbstractMap.SimpleEntry<>("put", element));
                case 1 -> operations.add(new AbstractMap.SimpleEntry<>("get", element));
                case 2 -> operations.add(new AbstractMap.SimpleEntry<>("remove", element));
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("HashMap is {}", operations.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 17751 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 7357 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 6916 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
