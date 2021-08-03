package com.techelevator.dao;

import com.techelevator.model.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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
        return null;
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return null;
    }
}
