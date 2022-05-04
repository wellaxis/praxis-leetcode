package com.witalis.praxis.leetcode.task.h9.p851;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p851.option.*;
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
    id = 851,
    description = "Loud and Rich",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GRAPH, TOPOLOGICAL_SORT, DEPTH_FIRST_SEARCH}
)
public class LoudAndRich extends LeetCodeTask<int[]> {
    public static final int LEN = 500;
    private int[][] richer;
    private int[] quiet;

    public static final String INFORMATION = """

        There is a group of n people labeled from 0 to n - 1 where each person
            has a different amount of money and a different level of quietness.

        You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi
            and an integer array quiet where quiet[i] is the quietness of the ith person.
            All the given data in richer are logically correct (i.e., the data will not lead you
            to a situation where x is richer than y and y is richer than x at the same time).

        Return an integer array answer where answer[x] = y if y is the least quiet person
            (that is, the person y with the smallest value of quiet[y])
            among all people who definitely have equal to or more money than the person x.

        Example:
            Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
            Output: [5,5,2,5,4,5,6,7]
            Explanation:
                answer[0] = 5.
                    Person 5 has more money than 3, which has more money than 1, which has more money than 0.
                    The only person who is quieter (has lower quiet[x]) is person 7,
                    but it is not clear if they have more money than person 0.
                answer[7] = 7.
                    Among all people that definitely have equal to or more money than person 7 (which could be
                    persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x]) is person 7.
                The other answers can be filled out with similar reasoning.""";

    public LoudAndRich(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.quiet = generateArray();
        this.richer = generateMatrix();

        log.info("Number is {}", quiet.length);

        var builder = new StringBuilder();
        for (int[] interval: richer) {
            builder.append(Arrays.toString(interval)).append(' ');
        }
        log.info("Richer is {}", builder);

        log.info("Quiet is {}", Arrays.toString(quiet));
    }

    private int[] generateArray() {
        var random = ThreadLocalRandom.current();

        int number = random.nextInt(1, LEN + 1);

        List<Integer> numbers = new ArrayList<>(IntStream.range(0, number).distinct().boxed().toList());
        Collections.shuffle(numbers);

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[][] generateMatrix() {
        final int richness = 10;
        final var random = ThreadLocalRandom.current();

        int number = quiet.length;

        List<int[]> riches = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                if (random.nextInt(0, richness + 1) == 0) {
                    riches.add(new int[] {i, j});
                }
            }
        }

        return riches.toArray(int [][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2626 ms
    @Override
    protected int[] original() {
        var original = new Original(richer, quiet);
        return original.process();
    }

    // time = 2125 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(richer, quiet);
        return practice.process();
    }

    // time = 961 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(richer, quiet);
        return solution.process();
    }
}
