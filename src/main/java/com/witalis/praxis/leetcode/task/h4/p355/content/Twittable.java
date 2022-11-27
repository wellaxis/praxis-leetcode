package com.witalis.praxis.leetcode.task.h4.p355.content;

import java.util.List;

/**
 * Desc: Twittable interface.
 * User: Wellaxis
 * Date: 11/27/2022
 */
public interface Twittable<T> {
    void postTweet(int userId, int tweetId);
    List<T> getNewsFeed(int userId);
    void follow(int followerId, int followeeId);
    void unfollow(int followerId, int followeeId);
}
