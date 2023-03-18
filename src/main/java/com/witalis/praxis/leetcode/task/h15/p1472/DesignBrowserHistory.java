package com.witalis.praxis.leetcode.task.h15.p1472;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1472.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1472,
    description = "Design Browser History",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, LINKED_LIST, STACK, DESIGN, DOUBLY_LINKED_LIST, DATA_STREAM}
)
public class DesignBrowserHistory extends LeetCodeTask<List<String>> {
    public static final int LEN = 20;
    public static final int SIZE = 100;
    public static final int COUNT = 5_000;

    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public static final String INFORMATION = """

        Description:
            You have a browser of one tab where you start on the homepage and you can visit another url,
                get back in the history number of steps or move forward in the history number of steps.

            Implement the BrowserHistory class:
                * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
                * void visit(string url) Visits url from the current page. It clears up all the forward history.
                * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x,
                  you will return only x steps. Return the current url after moving back in history at most steps.
                * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x,
                  you will forward only x steps. Return the current url after forwarding in history at most steps.

        Example:
            Input:
                ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
                [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
            Output:
                [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
            Explanation:
                BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
                browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
                browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
                browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
                browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
                browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
                browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
                browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
                browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
                browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
                browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com" """;

    public DesignBrowserHistory(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int count = random.nextInt(1, COUNT + 1);

        operations = new ArrayList<>(count);
        operations.add(new AbstractMap.SimpleEntry<>("BrowserHistory", generateURL()));

        for (int i = 1; i < count; i++) {
            if (i <= 5) {
                operations.add(new AbstractMap.SimpleEntry<>("visit", generateURL()));
            } else {
                int operation = random.nextInt(0, 3);
                String steps = String.valueOf(random.nextInt(1, SIZE + 1));
                switch (operation) {
                    case 0 -> operations.add(new AbstractMap.SimpleEntry<>("visit", generateURL()));
                    case 1 -> operations.add(new AbstractMap.SimpleEntry<>("back", steps));
                    case 2 -> operations.add(new AbstractMap.SimpleEntry<>("forward", steps));
                    default -> throw new IllegalArgumentException("unexpected operation");
                }
            }
        }

        log.info("Browser History: {}", operations.toString());
    }

    private String generateURL() {
        final var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        final var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 6) == 0) {
                builder.append('.');
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3837 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 3301 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 3443 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
