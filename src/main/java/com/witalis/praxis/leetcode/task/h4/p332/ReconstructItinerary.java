package com.witalis.praxis.leetcode.task.h4.p332;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p332.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 332,
    description = "Reconstruct Itinerary",
    difficulty = TaskDifficulty.HARD,
    tags = {DEPTH_FIRST_SEARCH, GRAPH, EULERIAN_CIRCUIT}
)
public class ReconstructItinerary extends LeetCodeTask<List<String>> {
    public static final int LEN = 300;

    private List<List<String>> tickets;

    public static final String INFORMATION = """

        Description:
            You are given a list of airline tickets where tickets[i] = [fromi, toi] represent
                the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

            All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
                If there are multiple valid itineraries, you should return the itinerary
                that has the smallest lexical order when read as a single string.
            
            * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

            You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

        Example:
            Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
            Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
            Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.""";

    public ReconstructItinerary(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.tickets = new ArrayList<>();
        tickets.add(List.of("JFK", generate()));
        for (int i = 0; i < len; i++) {
            tickets.add(List.of(generate(), generate()));
        }

        log.info("Tickets: {}", tickets);
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();
        builder
            .append((char) random.nextInt('A', 'Z' + 1))
            .append((char) random.nextInt('A', 'Z' + 1))
            .append((char) random.nextInt('A', 'Z' + 1));
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1337 ms
    @Override
    protected List<String> original() {
        var original = new Original(tickets);
        return original.process();
    }

    // time = 1277 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(tickets);
        return practice.process();
    }

    // time = 1146 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(tickets);
        return solution.process();
    }
}
