package com.witalis.praxis.leetcode.task.h5.p433;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p433.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 433,
    description = "Minimum Genetic Mutation",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, BREADTH_FIRST_SEARCH}
)
public class MinimumGeneticMutation extends LeetCodeTask<Integer> {
    public static final int LEN = 8;
    private String start;
    private String end;
    private String[] bank;

    public static final String INFORMATION = """

        Description:
            A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

            Suppose we need to investigate a mutation from a gene string start to a gene string end
                where one mutation is defined as one single character changed in the gene string.
                * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

            There is also a gene bank bank that records all the valid gene mutations.
                A gene must be in bank to make it a valid gene string.

            Given the two gene strings start and end and the gene bank bank,
                return the minimum number of mutations needed to mutate from start to end.
                If there is no such a mutation, return -1.

            Note that the starting point is assumed to be valid, so it might not be included in the bank.

        Example:
            Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
            Output: 3""";

    public MinimumGeneticMutation(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.start = generateGene();
        this.end = generateGene();
        this.bank = generateBank();

        log.info("Start gene is '{}'", start);
        log.info("End gene is '{}'", end);
        log.info("Gene bank is: {}", Arrays.toString(bank));
    }

    enum NucleotideType {
        A, C, G, T
    }

    private static String generateGene() {
        final var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();
        for (int i = 0; i < LEN; i++) {
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
        return builder.toString();
    }

    private static String[] generateBank() {
        final var random = ThreadLocalRandom.current();

        List<String> fullBank = new ArrayList<>();
        fillGeneBank(fullBank, "");
        Collections.shuffle(fullBank);

        List<String> weedGenes = new ArrayList<>();
        int[] weedIndices = random.ints(
            (long) (fullBank.size() * 0.2),
            0, fullBank.size()
        ).distinct().toArray();
        for (int weedIndex : weedIndices) {
            weedGenes.add(fullBank.get(weedIndex));
        }
        fullBank.removeAll(weedGenes);

        return fullBank.toArray(new String[0]);
    }

    private static void fillGeneBank(List<String> bank, String gene) {
        if (gene.length() == LEN) {
            bank.add(gene);
        } else {
            for (NucleotideType type : NucleotideType.values()) {
                fillGeneBank(bank, gene.concat(type.name()));
            }
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 98506 ms
    @Override
    protected Integer original() {
        var original = new Original(start, end, bank);
        return original.process();
    }

    // time = 83415 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(start, end, bank);
        return practice.process();
    }

    // time = 25511 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(start, end, bank);
        return solution.process();
    }
}
