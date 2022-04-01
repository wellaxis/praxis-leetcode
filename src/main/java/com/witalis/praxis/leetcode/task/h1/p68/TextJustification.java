package com.witalis.praxis.leetcode.task.h1.p68;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p68.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 68,
    description = "Text Justification",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, STRING, SIMULATION}
)
public class TextJustification extends LeetCodeTask<List<String>> {
    public static final int SIZE = 300;
    public static final int LEN = 20;
    public static final int WIDTH = 100;
    private String[] words;
    private int maxWidth;

    public static final String INFORMATION = """

        Given an array of strings words and a width maxWidth,
            format the text such that each line has exactly maxWidth
            characters and is fully (left and right) justified.

        You should pack your words in a greedy approach;
            that is, pack as many words as you can in each line.
            Pad extra spaces ' ' when necessary
            so that each line has exactly maxWidth characters.

        Extra spaces between words should be distributed
            as evenly as possible. If the number of spaces
            on a line does not divide evenly between words,
            the empty slots on the left will be assigned
            more spaces than the slots on the right.

        For the last line of text, it should be left-justified
            and no extra space is inserted between words.

        Note:
        * A word is defined as a character sequence consisting of non-space characters only.
        * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
        * The input array words contains at least one word.

        Example:
            Input:
                words = ["What","must","be","acknowledgment","shall","be"],
                maxWidth = 16
            Output:
                [
                  "What   must   be",
                  "acknowledgment  ",
                  "shall be        "
                ]
            Explanation:
                Note that the last line is "shall be    " instead of
                "shall     be", because the last line must be
                left-justified instead of fully-justified.
                Note that the second line is also left-justified
                because it contains only one word.""";

    public TextJustification(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.maxWidth = random.nextInt(1, WIDTH + 1);

        int count = random.nextInt(1, SIZE + 1);
        this.words = new String[count];
        while (count-- > 0) {
            int len = random.nextInt(1, Math.min(LEN, maxWidth) + 1);
            var word = new StringBuilder();
            while (len-- > 0) {
                if ((len & 1) != 0) {
                    word.append((char) random.nextInt('A', 'Z' + 1));
                } else {
                    word.append((char) random.nextInt('a', 'z' + 1));
                }
            }
            words[count] = word.toString();
        }

        log.info("Words are {}", Arrays.toString(words));
        log.info("Max width is {}", maxWidth);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 632 ms
    @Override
    protected List<String> original() {
        var original = new Original(words.clone(), maxWidth);
        return original.process();
    }

    // time = 513 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(words.clone(), maxWidth);
        return practice.process();
    }

    // time = 688 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(words.clone(), maxWidth);
        return solution.process();
    }
}
