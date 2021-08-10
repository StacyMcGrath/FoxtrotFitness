package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Progress;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcProgressDAO implements ProgressDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcProgressDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Progress> retrieveProgressByEventForAllUsers(int eventId) {
        List<Progress> allUserProgress = new ArrayList<>();

        String sql = "SELECT event_user.event_id, event_user.user_id, logged_activity.activity_type_id, " +
                "logged_activity.distance, logged_activity.activity_date from logged_activity " +
                "JOIN event_user ON logged_activity.user_id = event_user.user_id " +
                "JOIN event_activity_type ON event_user.event_id = event_activity_type.event_id " +
                "JOIN event on event_user.event_id = event.event_id " +
                "WHERE event_activity_type.event_id = ? AND (logged_activity.activity_date >= event.start_date AND " +
                "logged_activity.activity_date <= event.end_date) " +
                "AND logged_activity.activity_type_id IN (SELECT event_activity_type.activity_type_id FROM " +
                "event_activity_type WHERE event_id = ?) " +
                "GROUP BY event_user.event_id, event_user.user_id, logged_activity.activity_type_id, " +
                "logged_activity.distance, logged_activity.activity_date";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId, eventId);

        while(results.next()) {
            Progress progress = mapRowToProgress(results);
            allUserProgress.add(progress);
        }

        return allUserProgress;
    }

    @Override
    public List<Progress> retrieveProgressByEventForUser(int eventId, int userId) {
        List<Progress> individualProgress = new ArrayList<>();

        String sql = "SELECT event_user.event_id, event_user.user_id, logged_activity.activity_type_id, " +
                    "logged_activity.distance, logged_activity.activity_date from logged_activity " +
                    "JOIN event_user ON logged_activity.user_id = event_user.user_id " +
                    "JOIN event_activity_type ON event_user.event_id = event_activity_type.event_id " +
                    "JOIN event on event_user.event_id = event.event_id " +
                    "WHERE event_activity_type.event_id = ? AND event_user.user_id = ? " +
                    "AND (logged_activity.activity_date >= event.start_date AND logged_activity.activity_date <= event.end_date) " +
                    "AND logged_activity.activity_type_id IN (SELECT event_activity_type.activity_type_id FROM event_activity_type " +
                    "WHERE event_id = ?) " +
                    "GROUP BY event_user.event_id, event_user.user_id, logged_activity.activity_type_id, logged_activity.distance, " +
                    "logged_activity.activity_date";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId, userId, eventId);

        while(results.next()) {
            Progress progress = mapRowToProgress(results);
            individualProgress.add(progress);
        }

        return individualProgress;
    }

    @Override
    public List<Progress> retrieveProgressByGoalForUser(int goalId, int userId) {
        List<Progress> individualGoalProgress = new ArrayList<>();

        String sql = "SELECT goals.goal_id, goals.user_id, logged_activity.activity_type_id, logged_activity.distance, " +
                    "logged_activity.number_of_minutes, logged_activity.activity_date " +
                    "FROM logged_activity " +
                    "JOIN goals ON logged_activity.user_id = goals.user_id " +
                    "JOIN goal_activity_type ON goals.goal_id = goal_activity_type.goal_id " +
                    "WHERE goal_activity_type.goal_id = ? AND goals.user_id = ? " +
                    "AND (logged_activity.activity_date >= goals.start_date AND logged_activity.activity_date <= goals.end_date) " +
                    "AND logged_activity.activity_type_id IN (SELECT goal_activity_type.activity_type_id  " +
                    "FROM goal_activity_type " +
                    "WHERE goal_id = ?) " +
                    "GROUP BY goals.goal_id, goals.user_id, logged_activity.activity_type_id, logged_activity.distance, " +
                    "logged_activity.number_of_minutes, logged_activity.activity_date";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, goalId, userId, goalId);

        while(results.next()) {
            Progress progress = mapRowToGoalProgress(results);
            individualGoalProgress.add(progress);
        }

        return individualGoalProgress;
    }


    private Progress mapRowToProgress(SqlRowSet results) {
        Progress progress = new Progress();

        progress.setEventId(results.getInt("event_id"));
        progress.setUserId(results.getInt("user_id"));
        progress.setActivityTypeId(results.getInt("activity_type_id"));
        progress.setDistance(results.getDouble("distance"));
        progress.setActivityDate(results.getDate("activity_date"));

        return progress;
    }

    private Progress mapRowToGoalProgress(SqlRowSet results) {
        Progress progress = new Progress();

        progress.setGoalId(results.getInt("goal_id"));
        progress.setUserId(results.getInt("user_id"));
        progress.setActivityTypeId(results.getInt("activity_type_id"));
        progress.setDistance(results.getDouble("distance"));
        progress.setTimeInMinutes(results.getDouble("number_of_minutes"));
        progress.setActivityDate(results.getDate("activity_date"));

        return progress;
    }
}
