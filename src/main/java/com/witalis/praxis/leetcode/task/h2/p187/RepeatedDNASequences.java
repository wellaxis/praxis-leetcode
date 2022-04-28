package com.witalis.praxis.leetcode.task.h2.p187;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p187.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 187,
    description = "Repeated DNA Sequences",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, BIT_MANIPULATION, SLIDING_WINDOW, ROLLING_HASH, HASH_FUNCTION}
)
public class RepeatedDNASequences extends LeetCodeTask<List<String>> {
    public static final int LEN = 100_000;
    private String dna;

    public static final String INFORMATION = """

        The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
            * For example, "ACGAATTCCG" is a DNA sequence.
        When studying DNA, it is useful to identify repeated sequences within the DNA.

        Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
            that occur more than once in a DNA molecule. You may return the answer in any order.

        Example:
            Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
            Output: ["AAAAACCCCC","CCCCCAAAAA"]""";

    public RepeatedDNASequences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        var len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int type = random.nextInt(0, 4);
            char nucleotide = switch (type) {
                case 0 -> 'A';
                case 1 -> 'C';
                case 2 -> 'G';
                case 3 -> 'T';
                default -> throw new IllegalArgumentException("Incorrect nucleotide type.");
            };
            builder.append(nucleotide);
        }
        this.dna = builder.toString();

        log.info("The DNA sequence is '{}'", dna);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 28838 ms
    @Override
    protected List<String> original() {
        var original = new Original(dna);
        return original.process();
    }

    // time = 20870 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(dna);
        return practice.process();
    }

    // time = 26978 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(dna);
        return solution.process();
    }
}
