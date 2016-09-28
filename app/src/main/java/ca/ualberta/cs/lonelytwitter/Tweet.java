package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
/**
 * Created by Maxwell on 2016-09-13.
 */
public abstract class Tweet implements Comparable<Tweet> {
    private String message;
    private Date date;

    ArrayList<CurrentMood> tweetList = new ArrayList<CurrentMood>();

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongExeption {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongExeption();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public int compareTo(Tweet o) {
        return getDate().compareTo(o.getDate());
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
