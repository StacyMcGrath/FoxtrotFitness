package com.techelevator.dao;

import com.techelevator.model.Activity;
import com.techelevator.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcActivityDAO implements ActivityDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcActivityDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Activity logActivity(Activity activity) {
        Activity newActivity = new Activity();

        String sql = "INSERT INTO logged_activity (logged_activity_id, user_id, activity_type_id, activity_date, distance) " +
                "VALUES (DEFAULT, ?, ?, ?, ?) RETURNING logged_activity_id";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, activity.getUserID(), activity.getActivityTypeId(),
                activity.getActivityDate(), activity.getDistance());

        int newActivityId = 0;
        if (result.next()) {
            newActivityId = result.getInt("logged_activity_id");
        }
        newActivity.setActivityID(newActivityId);

        return newActivity;
    }

    @Override
    public List<Activity> retrieveActivitiesByUser(int userId) {
        List<Activity> activityList = new ArrayList<Activity>();

        String sql = "SELECT la.logged_activity_id, la.user_id, la.activity_type_id, la.activity_date, la.distance, ta.activity_type " +
                "FROM logged_activity la " +
                "JOIN activity_type ta ON la.activity_type_id = ta.activity_type_id " +
                "WHERE la.user_id = ? " +
                "ORDER BY la.activity_date DESC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Activity activity = mapRowToActivity(results);
            activityList.add(activity);
        }

        return activityList;
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return null;
    }

    private Activity mapRowToActivity(SqlRowSet results) {
        Activity activity = new Activity();
        activity.setActivityID(results.getInt("logged_activity_id"));
        activity.setUserID(results.getInt("user_id"));
        activity.setActivityTypeId(results.getInt("activity_type_id"));
        activity.setActivityDate(results.getDate("activity_date"));
        activity.setDistance(results.getDouble("distance"));
        activity.setActivityType(results.getString("activity_type"));

        return activity;
    }
}