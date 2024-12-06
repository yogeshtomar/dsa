package binaryHeaps;

import java.util.*;

public class Twitter {

    // Class for each tweet
    private static class Tweet {
        private final int id;
        private final int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private static class User {
        private final int id;
        private final Set<Integer> followees;
        private Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followees = new HashSet<>();
            follow(id);  // Follow oneself
        }

        // Post a new tweet
        public void post(int tweetId) {
            Tweet newTweet = new Tweet(tweetId, timestamp++);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }

        // Follow another user
        public void follow(int followeeId) {
            followees.add(followeeId);
        }

        // Unfollow a user
        public void unfollow(int followeeId) {
            followees.remove(followeeId);
        }
    }

    private static int timestamp = 0;
    private  final Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    private User getUser(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
        return userMap.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        getUser(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.time - a.time));

        if (user.tweetHead != null) {
            pq.add(user.tweetHead);
        }

        for (int followeeId : user.followees) {
            User followee = userMap.get(followeeId);
            if (followee != null && followee.tweetHead != null) {
                pq.add(followee.tweetHead);
            }
        }

        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            feed.add(tweet.id);
            count++;
            if (tweet.next != null) {
                pq.add(tweet.next);
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            getUser(followerId).follow(followeeId);
        }
    }

    public void unFollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            getUser(followerId).unfollow(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a tweet
        twitter.postTweet(1, 5);

        // User 1's news feed should return [5]
        System.out.println("User 1's feed: " + twitter.getNewsFeed(1));

        // User 1 follows user 2
        twitter.follow(1, 2);

        // User 2 posts a tweet
        twitter.postTweet(2, 6);

        // User 1's news feed should return [6, 5]
        System.out.println("User 1's feed after following User 2: " + twitter.getNewsFeed(1));

        // User 1 unfollows user 2
        twitter.unFollow(1, 2);

        // User 1's news feed should return [5]
        System.out.println("User 1's feed after unfollowing User 2: " + twitter.getNewsFeed(1));
    }
}
