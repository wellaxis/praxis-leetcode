package com.witalis.praxis.leetcode.task.h4.p355.option;

import com.witalis.praxis.leetcode.task.h4.p355.content.Twittable;
import com.witalis.praxis.leetcode.task.h4.p355.content.TwitterHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 355
 * Name: Design Twitter
 * URL: <a href="https://leetcode.com/problems/design-twitter/">Design Twitter</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class Twitter implements Twittable<Integer> {
        public static final int MAX_NEWS = 10;

        private final Map<Integer, Set<Integer>> followers;
        private final Deque<Twit> twits;

        record Twit (int id, int userId) {}

        public Twitter() {
            this.followers = new HashMap<>();
            this.twits = new ArrayDeque<>();
        }

        @Override
        public void postTweet(int userId, int tweetId) {
            twits.add(new Twit(tweetId, userId));
        }

        @Override
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> news = new LinkedList<>();

            int count = 0;
            Iterator<Twit> iterator = twits.descendingIterator();
            while (iterator.hasNext() && count < MAX_NEWS) {
                Twit twit = iterator.next();
                if (twit.userId == userId || followers.getOrDefault(userId, Set.of()).contains(twit.userId)) {
                    news.add(twit.id);
                    count++;
                }
            }

            return news;
        }

        @Override
        public void follow(int followerId, int followeeId) {
            followers.putIfAbsent(followerId, new HashSet<>());
            followers.computeIfPresent(followerId, (k, v) -> {v.add(followeeId); return v;});
        }

        @Override
        public void unfollow(int followerId, int followeeId) {
            followers.computeIfPresent(followerId, (k, v) -> {v.remove(followeeId); return v;});
        }
    }

    public List<String> process() {
        return TwitterHandler.process(operations, new Twitter());
    }
}
