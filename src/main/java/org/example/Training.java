package org.example;

import java.util.Date;

public class Training {
    private String type;
    private Date date;
    private int duration;
    private int calories;
    private String additionalInfo;
    private String username;

    public Training(String type, Date date, int duration, int calories, String additionalInfo, String username) {
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.calories = calories;
        this.additionalInfo = additionalInfo;
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    @Override
    public String toString() {
        return "Training{" +
                "type='" + type + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", calories=" + calories +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }


    public String getUsername() {
        return username;
    }
}
