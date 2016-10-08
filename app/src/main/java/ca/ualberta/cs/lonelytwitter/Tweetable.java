package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * Created by Maxwell on 2016-09-13.
 */
public interface Tweetable {

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate();
}
