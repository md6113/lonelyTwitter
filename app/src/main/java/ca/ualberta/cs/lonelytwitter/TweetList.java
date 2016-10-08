package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Maxwell on 2016-09-27.
 * The TweetList class permits us to create a tweet and have it belong somewhere where we can
 * easily manage it (delete it, add another, count the total number made, get one...).
 */
public class TweetList {
    /**
     * The Tweets.
     * @see #add(Tweet)
     * @see #getCount()
     * @see #getTweet(int)
     * @see #removeTweet(Tweet)
     * @see #getTweets()
     *
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        if (true == hasTweet(tweet))
            throw new IllegalArgumentException();
        tweets.add(tweet);
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Remove tweet.
     *
     * @param a the a
     */
    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public List getTweets() {
        Collections.sort(tweets);
        return tweets;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return tweets.size();
    }

}
