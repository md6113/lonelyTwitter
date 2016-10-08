package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Maxwell on 2016-09-13.
 */
public abstract class CurrentMood {
    private Date date;

    /**
     * Instantiates a new Current mood.
     *
     * @param date the date
     */
    public CurrentMood(Date date){
        this.date = date;
    }

    /**
     * Instantiates a new Current mood.
     */
    public CurrentMood(){
        this.date = new Date();
    }

    /**
     * Format string.
     *
     * @return the string
     */
    public abstract String format();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
