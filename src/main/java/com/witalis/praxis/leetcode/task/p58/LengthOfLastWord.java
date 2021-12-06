package com.witalis.praxis.leetcode.task.p58;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p58.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 58, description = "Length of Last Word")
public class LengthOfLastWord extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private String string;

    public static final String INFORMATION = """

        Given a string s consisting of some words
            separated by some number of spaces,
            return the length of the last word in the string.
                                                  
        A word is a maximal substring consisting of non-space characters only.
                                                
        Example:
            Input: s = "   fly me   to   the moon  "
            Output: 4
            Explanation: The last word is "moon" with length 4.""";

    public LengthOfLastWord(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = generate();

        log.info("String is {}", string);
    }

    private String generate() {
        final int spaceChance = 20; // letter ' '
        final int leftUpper = 65; // letter 'A'
        final int rightUpper = 90; // letter 'Z'
        final int leftLower = 97; // letter 'a'
        final int rightLower = 122; // letter 'z'

        var random = ThreadLocalRandom.current();
        var length = random.nextInt(0, LEN + 1);
        var builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (random.nextInt(0, spaceChance + 1) == spaceChance) {
                builder.append(' ');
            } else {
                int randomLimitedInt;
                if ((random.nextInt() & 1) == 1) {
                    randomLimitedInt = leftUpper + (int)
                        (random.nextFloat() * (rightUpper - leftUpper + 1));
                } else {
                    randomLimitedInt = leftLower + (int)
                        (random.nextFloat() * (rightLower - leftLower + 1));
                }
                builder.append((char) randomLimitedInt);
            }
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 576 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 453 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 455 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
