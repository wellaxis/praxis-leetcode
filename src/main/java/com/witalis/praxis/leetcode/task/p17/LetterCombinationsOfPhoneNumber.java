package com.witalis.praxis.leetcode.task.p17;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p17.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@LeetCode(id = 17, description = "Letter Combinations of a Phone Number")
public class LetterCombinationsOfPhoneNumber extends LeetCodeTask<List<String>> {
    public static final int MIN = 2;
    public static final int MAX = 9;
    public static final int LEN = 4;
    private String digits;

    public static final String INFORMATION = """

        Given a string containing digits from 2-9 inclusive,
            return all possible letter combinations that the number could represent.
            Return the answer in any order.
                                                
        A mapping of digit to letters (just like on the telephone buttons) is given below.
            Note that 1 does not map to any letters.
        
        Buttons: 1[] 2[abc] 3[def] 4[ghi] 5[jkl] 6[mno] 7[pqrs] 8[tuv] 9[wxyz]
        
        Example:
            Input: digits = "23"
            Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]""";

    public LetterCombinationsOfPhoneNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.digits = IntStream.generate(
                () -> random.nextInt(MIN, MAX + 1)
            )
            .limit(random.nextInt(0, LEN + 1))
            .mapToObj(String::valueOf)
            .reduce(
                "",
                String::concat
            );

        log.info("Digits are '{}'", digits);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 726 ms
    @Override
    protected List<String> original() {
        var original = new Original(digits);
        return original.process();
    }

    // time = 753 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(digits);
        return practice.process();
    }

    // time = 2441 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(digits);
        return solution.process();
    }
}
