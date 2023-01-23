package com.witalis.praxis.leetcode.task.h10.p997;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p997.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 997,
    description = "Find the Town Judge",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, GRAPH}
)
public class FindTownJudge extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int SIZE = 10_000;
    private int number;
    private int[][] trust;

    public static final String INFORMATION = """

        Description:
            In a town, there are n people labeled from 1 to n.
                There is a rumor that one of these people is secretly the town judge.

            If the town judge exists, then:
                * The town judge trusts nobody.
                * Everybody (except for the town judge) trusts the town judge.
                * There is exactly one person that satisfies properties 1 and 2.

            You are given an array trust where trust[i] = [ai, bi] representing
                that the person labeled ai trusts the person labeled bi.

            Return the label of the town judge if the town judge exists and can be identified,
                or return -1 otherwise.

        Example:
            Input: n = 3, trust = [[1,3],[2,3]]
            Output: 3""";

    public FindTownJudge(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);
        int size = random.nextInt(0, SIZE + 1);
        int count = 2 * size / number;

        Set<int[]> trusts = new HashSet<>();
        IntStream.rangeClosed(1, number).forEach(
            person1 -> {
                int pairs = random.nextInt(0, count + 1);
                IntStream.rangeClosed(0, pairs).forEach(
                    pair -> {
                        int person2 = random.nextInt(1, number + 1);
                        if (person1 != person2) {
                            trusts.add(new int[] {person1, person2});
                        }
                    }
                );
            }
        );
        this.trust = trusts.toArray(int[][]::new);

        log.info("Number: {}", number);
        log.info("Trusts: {}", Arrays.deepToString(trust));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5858 ms
    @Override
    protected Integer original() {
        var original = new Original(number, trust);
        return original.process();
    }

    // time = 1125 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number, trust);
        return practice.process();
    }

    // time = 776 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number, trust);
        return solution.process();
    }
}
