package com.techelevator.model;

import java.util.Date;

public class Progress {

    private int eventId;
    private int userId;
    private int activityTypeId;
    private double distance;
    private Date activityDate;

    public Progress() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(int activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
}
