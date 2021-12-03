package com.witalis.praxis.leetcode.task.p8;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p8.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(id = 8, description = "String to Integer (atoi)")
public class StringToIntegerAtoi extends LeetCodeTask<Integer> {
    private String string;

    public static final String INFORMATION = """

        Implement the myAtoi(string s) function, which converts a string
            to a 32-bit signed integer (similar to C/C++'s atoi function).
                                                                          
        The algorithm for myAtoi(string s) is as follows:

        1. Read in and ignore any leading whitespace.
        2. Check if the next character (if not already at the end of the string) is '-' or '+'.
             Read this character in if it is either.
             This determines if the final result is negative or positive respectively.
             Assume the result is positive if neither is present.
        3. Read in next the characters until the next non-digit character
             or the end of the input is reached. The rest of the string is ignored.
        4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
             If no digits were read, then the integer is 0.
             Change the sign as necessary (from step 2).
        5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1],
             then clamp the integer so that it remains in the range.
             Specifically, integers less than -2^31 should be clamped to -2^31,
             and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
        6. Return the integer as the final result.
        
        Note:
          * Only the space character ' ' is considered a whitespace character.
          * Do not ignore any characters other than the leading whitespace
            or the rest of the string after the digits.
        
        Example:
            Input: s = "4193 with words"
            Output: 4193
            Explanation:
                Step 1: "4193 with words" (no characters read because there is no leading whitespace)
                Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
                Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
            The parsed integer is 4193.
            Since 4193 is in the range [-231, 231 - 1], the final result is 4193.""";

    public StringToIntegerAtoi(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = "   -001357246805 is parsing number.";
        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1007 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 939 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 967 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
