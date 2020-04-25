package com.anmol.service;

import java.util.*;

class Twitter {

    Map<Integer, Set<Integer>> followers;
    Map<Integer, TwitterNode> userFeeds;
    int count = 0;

    static class TwitterNode {
        int tweetId;
        int userId;
        TwitterNode prev;
        TwitterNode next;
        int count;

        TwitterNode(int userId, int tweetId, int count) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.count = count;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        followers = new HashMap<>();
        userFeeds = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        count++;
        updateFeed(userId, tweetId, count, userId);
        Set<Integer> followerList = followers.get(userId);
        if(followerList==null || followerList.isEmpty()) {
            return;
        }
        for(int follower : followerList) {
            updateUserFeed(follower, tweetId, count, userId);
        }
    }

    public void updateUserFeed(int followerId, int tweetId, int count, int postedBy) {
        updateFeed(followerId, tweetId, count, postedBy);
    }

    private void updateFeed(int followerId, int tweetId, int count, int postedBy) {
        TwitterNode userFeed = userFeeds.get(followerId);
        if (userFeed == null) {
            userFeed = new TwitterNode(postedBy, tweetId, count);
        } else {
            TwitterNode temp = new TwitterNode(postedBy, tweetId, count);
            temp.next = userFeed;
            userFeed.prev = temp;
            userFeed = temp;
        }
        userFeeds.put(followerId, userFeed);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(userFeeds.get(userId) == null) {
            return new ArrayList<>();
        }

        TwitterNode temp = userFeeds.get(userId);
        List<Integer> result = new ArrayList<>();
        while(temp!=null && result.size() < 10) {
            result.add(temp.tweetId);
            temp = temp.next;
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followerSet = followers.get(followerId);
        if(followerSet == null) {
            followerSet = new HashSet<>();
        }
        followerSet.add(followeeId);
        followers.put(followerId, followerSet);
        TwitterNode followeeFeed = userFeeds.get(followeeId);
        mergeUserFeedWithFolloweeTweets(userFeeds.get(followerId), followeeFeed, followerId, followeeId);
    }

    private void mergeUserFeedWithFolloweeTweets(TwitterNode followerFeed, TwitterNode followeeFeed, int followerId, int followeeId) {
        if(followeeFeed == null) {
            return;
        }
        TwitterNode temp = followeeFeed;
        while (temp!=null) {
            if(temp.userId == followeeId) {
                TwitterNode copy = new TwitterNode(temp.userId, temp.tweetId, temp.count);
                TwitterNode followerStart = followerFeed;
                while (followerStart.count > copy.count){
                    followerStart = followerStart.next;
                }
                copy.next = followerStart;
                if(followerStart.prev !=null) {
                    followerStart.prev.next = copy;
                    followerStart.prev = copy;
                } else {
                    followerStart.prev = copy;
                    followerFeed = copy;
                }
            }
            temp = temp.next;
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return ;
        Set<Integer> followerSet = followers.get(followerId);
        if(followerSet == null || !followerSet.contains(followeeId)) {
            return;
        }
        followerSet.remove(followeeId);
//        removeFolloweeTweets
    }

    public static void main(String[] args) {
        /**
         * ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
         * [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
         */
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.postTweet(1,7);
        twitter.postTweet(2,10);
        twitter.postTweet(2,15);
        List<Integer> userFeed1 = twitter.getNewsFeed(1);
        System.out.println(userFeed1);
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        List<Integer> userFeed2 = twitter.getNewsFeed(1);
        System.out.println(userFeed2);
        twitter.unfollow(1,2);
        List<Integer> userFeed3 = twitter.getNewsFeed(1);
        System.out.println(userFeed3);
    }
}
