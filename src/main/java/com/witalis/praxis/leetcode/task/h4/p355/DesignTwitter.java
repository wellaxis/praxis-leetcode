package com.witalis.praxis.leetcode.task.h4.p355;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p355.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 355,
    description = "Design Twitter",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, LINKED_LIST, DESIGN, HEAP}
)
public class DesignTwitter extends LeetCodeTask<List<String>> {
    public static final int LEN = 30_000;
    public static final int UID = 500;
    public static final int TID = 10_000;

    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
                and is able to see the 10 most recent tweets in the user's news feed.

            Implement the Twitter class:
                * Twitter() Initializes your twitter object.
                * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
                  Each call to this function will be made with a unique tweetId.
                * List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
                  Each item in the news feed must be posted by users who the user followed or by the user themself.
                  Tweets must be ordered from most recent to least recent.
                * void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
                * void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

        Example:
            Input
                ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
                [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
            Output
                [null, null, [5], null, null, [6, 5], null, [5]]
            Explanation
                Twitter twitter = new Twitter();
                twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
                twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
                twitter.follow(1, 2);    // User 1 follows user 2.
                twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
                twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
                twitter.unfollow(1, 2);  // User 1 unfollows user 2.
                twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.""";

    public DesignTwitter(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("Twitter", null));

        Set<Integer> tweetIds = new HashSet<>();
        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            int operation = random.nextInt(0, 4);
            switch (operation) {
                case 0 -> {
                    int userId = random.nextInt(1, UID + 1);
                    int tweetId;
                    do {
                        tweetId = random.nextInt(0, TID + 1);
                    } while (tweetIds.contains(tweetId));
                    tweetIds.add(tweetId);
                    int[] postData = new int[] {userId, tweetId};
                    operations.add(new AbstractMap.SimpleEntry<>("postTweet", postData));
                }
                case 1 -> {
                    int userId = random.nextInt(1, UID + 1);
                    int[] feedData = new int[] {userId};
                    operations.add(new AbstractMap.SimpleEntry<>("getNewsFeed", feedData));
                }
                case 2 -> {
                    int followerId = random.nextInt(1, UID + 1);
                    int followeeId;
                    do {
                        followeeId = random.nextInt(1, UID + 1);
                    } while (followeeId == followerId);
                    int[] followData = new int[] {followerId, followeeId};
                    operations.add(new AbstractMap.SimpleEntry<>("follow", followData));
                }
                case 3 -> {
                    int followerId = random.nextInt(1, UID + 1);
                    int followeeId;
                    do {
                        followeeId = random.nextInt(1, UID + 1);
                    } while (followeeId == followerId);
                    int[] unfollowData = new int[] {followerId, followeeId};
                    operations.add(new AbstractMap.SimpleEntry<>("unfollow", unfollowData));
                }
                default -> throw new IllegalArgumentException("Unexpected operation");
            }
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 365900 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 219904 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 437308 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
