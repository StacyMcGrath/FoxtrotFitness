package com.techelevator.dao;

import com.techelevator.model.Activity;
import java.util.List;

public interface ActivityDAO {

    Activity logActivity(Activity activity);
    List<Activity> retrieveActivitiesByUser(int userId);
    Activity updateActivity(Activity activity);

}
