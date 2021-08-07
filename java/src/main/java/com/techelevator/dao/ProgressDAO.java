package com.techelevator.dao;

import com.techelevator.model.Progress;

import java.util.List;

public interface ProgressDAO {
    List<Progress> retrieveProgressByEventForAllUsers(int eventId);

    List<Progress> retrieveProgressByEventForUser(int eventId, int userId);

    List<Progress> retrieveProgressByGoalForUser(int goalId, int userId);
}
