package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Goal;
import com.techelevator.model.UserEvent;

import java.util.List;

public interface GoalDAO {

    List<Goal> retrievePremadeGoals();
    Goal retrieveGoalById(int goalId);
    List<Goal> retrieveGoalsByUser(int userId);
    Goal addNewGoal(Goal goal);

}
