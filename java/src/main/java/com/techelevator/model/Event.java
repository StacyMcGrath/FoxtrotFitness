package com.techelevator.model;

import java.util.List;
import java.util.Date;

public class Event {

    private int eventId;
    private String eventName;
    private String description;
    private List<String> activityType;
    private Date startDate;
    private Date endDate;
    private double userActivityGoal;
    private double totalActivityGoal;

    public Event() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getActivityType() {
        return activityType;
    }

    public void setActivityType(List<String> activityType) {
        this.activityType = activityType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getUserActivityGoal() {
        return userActivityGoal;
    }

    public void setUserActivityGoal(double userActivityGoal) {
        this.userActivityGoal = userActivityGoal;
    }

    public double getTotalActivityGoal() {
        return totalActivityGoal;
    }

    public void setTotalActivityGoal(double totalActivityGoal) {
        this.totalActivityGoal = totalActivityGoal;
    }
}




