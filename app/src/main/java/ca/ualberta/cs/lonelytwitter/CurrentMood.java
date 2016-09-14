package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by Maxwell on 2016-09-13.
 */
public abstract class CurrentMood {
    private Date date;

    public CurrentMood(Date date){
        this.date = date;
    }

    public CurrentMood(){
        this.date = new Date();
    }

    public abstract String format();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
