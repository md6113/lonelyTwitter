package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Maxwell on 2016-09-13.
 */
public abstract class Tweet implements Comparable<Tweet> {
    private String message;
    private Date date;

    /**
     * The Tweet list.
     */
    ArrayList<CurrentMood> tweetList = new ArrayList<CurrentMood>();

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongExeption the tweet too long exeption
     */
    public void setMessage(String message) throws TweetTooLongExeption {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongExeption();
        }
        this.message = message;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Compares the date on a tweet to that obtained from getDate.
     *
     * @return a decision as to whether or not the two dates matched
     */
    public int compareTo(Tweet o) {
        return getDate().compareTo(o.getDate());
    }

    /**
     * Turns the date into a string and concatenates the message onto the end of it.
     *
     * @return the date properly formatted.
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
