package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

/**
 * Created by Maxwell on 2016-09-27.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        //assertTrue(false);
        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello!");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        list.add(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }

    public void testDuplicateTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        list.add(a);
        try{
            list.add(a);
            fail();
        }catch (IllegalArgumentException e) {

        }
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.add(a);
        list.add(b);

        assertTrue(2==list.getCount());
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!", new Date("September 13 2003"));
        Tweet b = new NormalTweet("Hi!", new Date("September 19 2003"));
        Tweet c = new NormalTweet("Hi there!", new Date("September 22 2002"));

        list.add(c);
        list.add(a);
        list.add(b);

        List d = list.getTweets();

        assertEquals(a, d.get(1));
        assertEquals(b, d.get(2));
        assertEquals(c, d.get(0));
    }

}
