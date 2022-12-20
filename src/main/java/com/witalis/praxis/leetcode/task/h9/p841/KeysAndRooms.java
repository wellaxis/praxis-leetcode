package com.witalis.praxis.leetcode.task.h9.p841;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p841.option.*;
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
    id = 841,
    description = "Keys and Rooms",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class KeysAndRooms extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int QTY = 10;
    private List<List<Integer>> rooms;

    public static final String INFORMATION = """

        Description:
            There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
                Your goal is to visit all the rooms.
                However, you cannot enter a locked room without having its key.

            When you visit a room, you may find a set of distinct keys in it.
                Each key has a number on it, denoting which room it unlocks,
                and you can take all of them with you to unlock the other rooms.

            Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

        Example:
            Input: rooms = [[1],[2],[3],[]]
            Output: true
            Explanation:
                We visit room 0 and pick up key 1.
                We then visit room 1 and pick up key 2.
                We then visit room 2 and pick up key 3.
                We then visit room 3.
                Since we were able to visit every room, we return true.""";

    public KeysAndRooms(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);

        this.rooms = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            rooms.add(
                random.ints(
                    random.nextInt(0, QTY + 1),
                    0, len
                ).boxed().distinct().toList()
            );
        }

        log.info("Rooms[n = {}]: {}", rooms.size(), rooms);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4050 ms
    @Override
    protected Boolean original() {
        var original = new Original(rooms);
        return original.process();
    }

    // time = 3490 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(rooms);
        return practice.process();
    }

    // time = 1355 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(rooms);
        return solution.process();
    }
}
