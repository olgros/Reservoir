package com.anupcowkur.reservoir;

import java.util.Calendar;

/**
 * Created by olger.rosero on 23/05/2017.
 */

public class ReservoirData {
    private String json;
    private long timeSave;
    private long timeExpired;

    public ReservoirData(){
        Calendar calendar = Calendar.getInstance();
        timeSave = calendar.getTimeInMillis();
    }
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public long getTimeSave() {
        return timeSave;
    }

    public void setTimeSave(long timeSave) {
        this.timeSave = timeSave;
    }

    public long getTimeExpired() {
        return timeExpired;
    }

    public void setTimeExpired(long timeExpired) {
        this.timeExpired = timeExpired;
    }
    public boolean expired(){
        Calendar calendar = Calendar.getInstance();
        return  ((calendar.getTimeInMillis() - timeSave) > timeExpired);
    }
}
