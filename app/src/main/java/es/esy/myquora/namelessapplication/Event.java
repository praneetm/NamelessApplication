package es.esy.myquora.namelessapplication;

import java.util.Date;

/**
 * Created by praneet on 22/05/17.
 */

public class Event {
    public String mDescription;
    public float mAmount;
    public String mTag;
    public String mDate;

    public Event(String date, String description, String tag, float amount){
        this.mDate = date;
        this.mDescription = description;
        this.mAmount = amount;
        this.mTag = tag;
    }


}
