package com.witalis.praxis.leetcode.task.h5.p460;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p460.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 460,
    description = "LFU Cache",
    difficulty = TaskDifficulty.HARD,
    tags = {HASH_TABLE, LINKED_LIST, DESIGN, DOUBLY_LINKED_LIST}
)
public class LFUCache extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int SIZE = 200_000;
    public static final int KEY = 100_000;
    public static final int VALUE = 1_000_000_000;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Design and implement a data structure for a Least Frequently Used (LFU) cache.

            Implement the LFUCache class:
                * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
                * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
                * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
                  When the cache reaches its capacity, it should invalidate and remove the least frequently used key
                  before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency),
                  the least recently used key would be invalidated.

            To determine the least frequently used key, a use counter is maintained for each key in the cache.
                The key with the smallest use counter is the least frequently used key.

            When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
                The use counter for a key in the cache is incremented either a get or put operation is called on it.

            The functions get and put must each run in O(1) average time complexity.

        Example:
            Input
                ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
                [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
            Output
                [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
            Explanation
                // cnt(x) = the use counter for key x
                // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
                LFUCache lfu = new LFUCache(2);
                lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
                lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
                lfu.get(1);      // return 1, cache=[1,2], cnt(2)=1, cnt(1)=2
                lfu.put(3, 3);   // cache=[3,1], cnt(3)=1, cnt(1)=2, 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                lfu.get(2);      // return -1 (not found)
                lfu.get(3);      // return 3, cache=[3,1], cnt(3)=2, cnt(1)=2
                lfu.put(4, 4);   // cache=[4,3], cnt(4)=1, cnt(3)=2, Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                lfu.get(1);      // return -1 (not found)
                lfu.get(3);      // return 3, cache=[3,4], cnt(4)=1, cnt(3)=3
                lfu.get(4);      // return 4, cache=[4,3], cnt(4)=2, cnt(3)=3""";

    public LFUCache(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int capacity = random.nextInt(1, LEN + 1);

        this.operations = new ArrayList<>(SIZE);
        operations.add(new AbstractMap.SimpleEntry<>("LFUCache", new int[] {capacity}));

        IntStream.range(1, SIZE).forEach(
            i -> {
                int key = random.nextInt(0, KEY + 1);
                int value = random.nextInt(0, VALUE + 1);
                if (random.nextBoolean()) {
                    operations.add(new AbstractMap.SimpleEntry<>("put", new int[] {key, value}));
                } else {
                    operations.add(new AbstractMap.SimpleEntry<>("get", new int[] {key}));
                }
            }
        );

        log.info("LFUCache: {}", operations.toString());
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
