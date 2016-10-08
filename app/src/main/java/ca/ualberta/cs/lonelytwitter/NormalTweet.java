package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Maxwell on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a normal Tweet with given string parameter.
     *
     * @param message this parameter is the given string for the tweet. It is...
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public NormalTweet(String message, Date date) {super(message, date); }

    /**
     * Documents the property that Normal tweets are not important.
     *
     * @return the decision false to demonstrate that Normal tweets are not important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
