package com.witalis.praxis.leetcode.task.h4.p355.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Twitter operations handler
 * User: Wellaxis
 * Date: 11/27/2022
 */
@Slf4j
public final class TwitterHandler {

    private TwitterHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        Twittable<Integer> twittable
    ) {
        List<String> results = new ArrayList<>();
        Twittable<Integer> twitter = null;

        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            var data = operation.getValue();
            switch (name) {
                case "Twitter" -> {
                    assert twitter == null;
                    twitter = twittable;
                    results.add(null);
                }
                case "postTweet" -> {
                    assert twitter != null;
                    twitter.postTweet(data[0], data[1]);
                    results.add(null);
                }
                case "getNewsFeed" -> {
                    assert twitter != null;
                    var twits = twitter.getNewsFeed(data[0]);
                    results.add(twits.toString());
                }
                case "follow" -> {
                    assert twitter != null;
                    twitter.follow(data[0], data[1]);
                    results.add(String.format("%d -> %d", data[0], data[1]));
                }
                case "unfollow" -> {
                    assert twitter != null;
                    twitter.unfollow(data[0], data[1]);
                    results.add(String.format("%d <~ %d", data[0], data[1]));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
