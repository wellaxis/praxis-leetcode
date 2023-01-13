package com.witalis.praxis.leetcode.task.h23.p2246;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2246.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2246,
    description = "Longest Path With Different Adjacent Characters",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, STRING, TREE, DEPTH_FIRST_SEARCH, GRAPH, TOPOLOGICAL_SORT}
)
public class LongestPathWithDifferentAdjacentCharacters extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int[] parents;
    private String labels;

    public static final String INFORMATION = """

        Description:
            You are given a tree (i.e. a connected, undirected graph that has no cycles)
                rooted at node 0 consisting of n nodes numbered from 0 to n - 1.
                The tree is represented by a 0-indexed array parent of size n,
                where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

            You are also given a string s of length n, where s[i] is the character assigned to node i.

            Return the length of the longest path in the tree such that
                no pair of adjacent nodes on the path have the same character assigned to them.

        Example:
            Input: parent = [-1,0,0,1,1,2], s = "abacbe"
            Output: 3
            Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3.
                The length of this path is 3, so 3 is returned.
                It can be proven that there is no longer path that satisfies the conditions.""";

    public LongestPathWithDifferentAdjacentCharacters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int number = random.nextInt(1, LEN + 1);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.labels = builder.toString();

        this.parents = new int[number];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(count);
        parents[count++] = -1;
        while (!queue.isEmpty() && count < number) {
            int parent = queue.poll();
            int mode = random.nextInt(1, 4);
            for (int m = 0; m < mode; m++) {
                if (count < number) {
                    parents[count] = parent;
                    queue.offer(count);
                    count++;
                }
            }
        }

        log.info("Number: {}", number);
        log.info("Parent: {}", Arrays.toString(parents));
        log.info("Labels: {}", labels);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4892 ms
    @Override
    protected Integer original() {
        var original = new Original(parents, labels);
        return original.process();
    }

    // time = 4099 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(parents, labels);
        return practice.process();
    }

    // time = 1736 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(parents, labels);
        return solution.process();
    }
}
