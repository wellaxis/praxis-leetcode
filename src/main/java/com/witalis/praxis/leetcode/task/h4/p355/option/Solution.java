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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    class Twitter implements Twittable<Integer> {
        private final Map<Integer, Integer> tweetVsUser;
        private final Map<Integer, Set<Integer>> userVsFollowees;
        private final List<Integer> tweets;

        public Twitter() {
            this.tweetVsUser = new HashMap<>();
            this.userVsFollowees = new HashMap<>();
            this.tweets = new ArrayList<>();
        }

        @Override
        public void postTweet(int userId, int tweetId) {
            tweets.add(tweetId);
            tweetVsUser.put(tweetId, userId);
        }

        @Override
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> ans = new ArrayList<>();
            int count = 0;
            for (int i = tweets.size() - 1; i >= 0 && count < 10; i--) {
                if (tweetVsUser.get(tweets.get(i)).equals(userId) || (userVsFollowees.get(userId) != null && userVsFollowees.get(userId).contains(tweetVsUser.get(tweets.get(i))))) {
                    ans.add(tweets.get(i));
                    count++;
                }
            }
            return ans;
        }

        @Override
        public void follow(int followerId, int followeeId) {
            if(userVsFollowees.get(followerId) == null) {
                userVsFollowees.put(followerId, new HashSet<>());
            }
            userVsFollowees.get(followerId).add(followeeId);
        }

        @Override
        public void unfollow(int followerId, int followeeId) {
            if (userVsFollowees.get(followerId) != null) {
                userVsFollowees.get(followerId).remove(followeeId);
            }
        }
    }

    public List<String> process() {
        return TwitterHandler.process(operations, new Twitter());
    }
}
