package com.witalis.praxis.leetcode.task.h15.p1443;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1443.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1443,
    description = "Minimum Time to Collect All Apples in a Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MinimumTimeToCollectAllApplesInTree extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int number;
    private int[][] edges;
    private List<Boolean> hasApple;

    public static final String INFORMATION = """

        Description:
            Given an undirected tree consisting of n vertices numbered from 0 to n-1,
                which has some apples in their vertices. You spend 1 second to walk over one edge of the tree.
                Return the minimum time in seconds you have to spend to collect all apples in the tree,
                starting at vertex 0 and coming back to this vertex.

            The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means
                that exists an edge connecting the vertices ai and bi.
                Additionally, there is a boolean array hasApple, where hasApple[i] = true means
                that vertex i has an apple; otherwise, it does not have any apple.

        Example:
            Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
            Output: 8
            Explanation: The figure above represents the given tree where red vertices have an apple.
                One optimal path to collect all apples is shown by the green arrows.""";

    public MinimumTimeToCollectAllApplesInTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        this.hasApple = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            hasApple.add(i, random.nextBoolean());
        }

        this.edges = new int[number - 1][2];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(count);
        while (!queue.isEmpty() && count < number - 1) {
            int parent = queue.poll();
            int mode = random.nextInt(1, 6);
            for (int m = 0; m < mode; m++) {
                if (count < number - 1) {
                    edges[count] = new int[] {parent, ++count};
                    queue.offer(count);
                }
            }
        }

        log.info("Number N: {}", number);
        log.info("Edges: {}", Arrays.deepToString(edges));
        log.info("Has apples: {}", hasApple.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 24096 ms
    @Override
    protected Integer original() {
        var original = new Original(number, edges, hasApple);
        return original.process();
    }

    // time = 21233 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number, edges, hasApple);
        return practice.process();
    }

    // time = 5789 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number, edges, hasApple);
        return solution.process();
    }
}
