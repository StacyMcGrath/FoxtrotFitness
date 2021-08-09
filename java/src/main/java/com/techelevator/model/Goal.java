package com.techelevator.model;

import java.util.List;
import java.util.Date;

public class Goal {

    private int goalId;
    private String goalName;
    private String description;
    private List<String> activityType;
    private Date startDate;
    private Date endDate;
    private double activityGoal;
    private String activityUnits;
    private int userId;

    public Goal() {
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
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

    public double getActivityGoal() {
        return activityGoal;
    }

    public void setActivityGoal(double activityGoal) {
        this.activityGoal = activityGoal;
    }

    public String getActivityUnits() {
        return activityUnits;
    }

    public void setActivityUnits(String activityUnits) {
        this.activityUnits = activityUnits;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
