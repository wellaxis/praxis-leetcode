package com.witalis.praxis.leetcode.task.p38;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p38.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 38, description = "Count and Say")
public class CountAndSay extends LeetCodeTask<String> {
    public static final int LEN = 30;
    private int number;

    public static final String INFORMATION = """

        The count-and-say sequence is a sequence of digit strings
            defined by the recursive formula:
        
            * countAndSay(1) = "1"
            * countAndSay(n) is the way you would "say" the digit string
              from countAndSay(n-1), which is then converted into a different digit string.
                                                                    
        To determine how you "say" a digit string, split it
            into the minimal number of groups so that each group
            is a contiguous section all of the same character.
            Then for each group, say the number of characters,
            then say the character. To convert the saying into a digit string,
            replace the counts with a number and concatenate every saying.
                                                                          
        For example, the saying and conversion for digit string "3322251":
            1. "3322251"
            2. two 3's, three 2's, one 5, and one 1
            3. 2 3 + 3 2 + 1 5 + 1 1
            4. "23321511"
           
        Given a positive integer n,
            return the nth term of the count-and-say sequence.

        Example:
            Input: n = 4
            Output: "1211"
            Explanation:
                countAndSay(1) = "1"
                countAndSay(2) = say "1" = one 1 = "11"
                countAndSay(3) = say "11" = two 1's = "21"
                countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211" """;

    public CountAndSay(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current()
            .nextInt(1, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2178 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 1550 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 1119 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
