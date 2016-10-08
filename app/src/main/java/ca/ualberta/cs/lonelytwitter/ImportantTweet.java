package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Maxwell on 2016-09-13.
 */
public class ImportantTweet extends Tweet{

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Documents the property that Normal tweets are not important.
     *
     * @return the decision false to demonstrate that Normal tweets are not important
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
