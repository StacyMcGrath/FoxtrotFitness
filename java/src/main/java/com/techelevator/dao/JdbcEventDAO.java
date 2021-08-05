package com.techelevator.dao;

import com.techelevator.model.Activity;
import com.techelevator.model.Event;
import com.techelevator.model.UserEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEventDAO implements EventDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcEventDAO(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Event> retrieveEvents() {

        List<Event> eventList = new ArrayList<Event>();

        String sql = "SELECT event.event_id, event.event_name, event.description, event.start_date, event.end_date, " +
                "event.user_activity_goal, event.total_activity_goal FROM event " +
                "ORDER BY event.start_date";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Event event = mapRowToEvent(results);
            eventList.add(event);
        }

        return eventList;
    }

    @Override
    public Event retrieveEventById(int eventId) {
        Event event = null;

        String sql = "SELECT event.event_id, event.event_name, event.description, event.start_date, event.end_date, " +
                "event.user_activity_goal, event.total_activity_goal FROM event " +
                "WHERE event.event_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, eventId);

        if(result.next()){
            event = mapRowToEvent(result);
        }
        return event;
    }

    @Override
    public List<Event> retrieveEventsByUser(int userID) {

        List<Event> eventList = new ArrayList<Event>();

        String sql = "SELECT event.event_id, event.event_name, event.description, event.start_date, event.end_date, " +
                "event.user_activity_goal, event.total_activity_goal " +
                "FROM event " +
                "JOIN event_user ON event_user.event_id = event.event_id " +
                "WHERE event_user.user_id = ? " +
                "ORDER BY event.end_date";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);

        while (results.next()) {
            Event event = mapRowToEvent(results);
            eventList.add(event);
        }

        return eventList;
    }

    @Override
    public void addEventToUser(UserEvent userEvent) {

        String sql = "INSERT INTO event_user (event_id, user_id) VALUES (?, ?)";

        jdbcTemplate.update(sql, userEvent.getEventId(), userEvent.getUserID());
    }


    private Event mapRowToEvent(SqlRowSet results) {
        Event event = new Event();
        event.setEventId(results.getInt("event_id"));
        event.setEventName(results.getString("event_name"));
        event.setDescription(results.getString("description"));
        event.setStartDate(results.getDate("start_date"));
        event.setEndDate(results.getDate("end_date"));
        event.setUserActivityGoal(results.getDouble("user_activity_goal"));
        event.setTotalActivityGoal(results.getDouble("total_activity_goal"));

        List<String> activityListForEvent = new ArrayList<>();

        activityListForEvent = getActivityListForEvent(results.getInt("event_id"));
        if(activityListForEvent != null) {
            event.setActivityType(activityListForEvent);
        }
        return event;
    }

    private List<String> getActivityListForEvent(int eventId) {

        String sql = "SELECT activity_type.activity_type FROM activity_type " +
                "JOIN event_activity_type ON event_activity_type.activity_type_id  = activity_type.activity_type_id " +
                "JOIN event ON event.event_id = event_activity_type.event_id " +
                "WHERE event.event_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId);

        List<String> activityListForEvent = new ArrayList<>();

        while (results.next()) {

            String activity_type = results.getString("activity_type");
            activityListForEvent.add(activity_type);
        }

        return activityListForEvent;

    }
}
