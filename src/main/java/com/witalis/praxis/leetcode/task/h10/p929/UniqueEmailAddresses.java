package com.witalis.praxis.leetcode.task.h10.p929;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p929.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 929,
    description = "Unique Email Addresses",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class UniqueEmailAddresses extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final String SUFFIX = ".com";

    private String[] emails;

    public static final String INFORMATION = """

        Description:
            Every valid email consists of a local name and a domain name, separated by the '@' sign.
                Besides lowercase letters, the email may contain one or more '.' or '+'.

            * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.

            If you add periods '.' between some characters in the local name part of an email address,
                mail sent there will be forwarded to the same address without dots in the local name.
                Note that this rule does not apply to domain names.

            * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.

            If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
                This allows certain emails to be filtered. Note that this rule does not apply to domain names.

            * For example, "m.y+name@email.com" will be forwarded to "my@email.com".

            It is possible to use both of these rules at the same time.

            Given an array of strings emails where we send one email to each emails[i],
                return the number of different addresses that actually receive mails.

        Example:
            Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
            Output: 2
            Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.""";

    public UniqueEmailAddresses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.emails = new String[len];
        for (int i = 0; i < len; i++) {
            emails[i] = generate();
        }

        log.info("Emails: {}", Arrays.toString(emails));
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        int n;
        StringBuilder builder = new StringBuilder();
        // local name
        n = random.nextInt(1, LEN / 2);
        for (int i = 0; i < n; i++) {
            if (i > 0 && random.nextInt(0, 5) == 0) {
                builder.append('+');
            } else {
                if (random.nextInt(0, 5) == 0) {
                    builder.append('.');
                } else {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                }
            }
        }
        // middle
        builder.append('@');
        // domain name
        n = random.nextInt(1, LEN / 2);
        for (int i = 0; i < n; i++) {
            if (random.nextInt(0, 5) == 0) {
                builder.append('.');
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }
        // suffix
        builder.append(SUFFIX);

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1604 ms
    @Override
    protected Integer original() {
        var original = new Original(emails);
        return original.process();
    }

    // time = 704 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(emails);
        return practice.process();
    }

    // time = 783 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(emails);
        return solution.process();
    }
}
