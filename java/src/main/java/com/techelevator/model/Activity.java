package com.techelevator.model;

import java.util.Date;

public class Activity {

    private int activityID;
    private int userID;
    private int activityTypeId;
    private Date activityDate;
    private double distance;
    private double numberOfMinutes;
    private String activityType;



    public Activity() {
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(int activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public double getNumberOfMinutes() {
        return numberOfMinutes;
    }

    public void setNumberOfMinutes(double numberOfMinutes) {
        this.numberOfMinutes = numberOfMinutes;
    }

}
