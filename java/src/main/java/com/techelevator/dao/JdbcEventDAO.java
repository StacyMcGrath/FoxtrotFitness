package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

        String sql = "SELECT event.event_id, event.event_name, event.description, event.long_description, event.start_date, event.end_date, " +
                "event.user_activity_goal, event.total_activity_goal, event.image_name FROM event " +
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

        String sql = "SELECT event.event_id, event.event_name, event.description, event.long_description, event.start_date, event.end_date, " +
                "event.user_activity_goal, event.total_activity_goal, event.image_name FROM event " +
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

        String sql = "SELECT event.event_id, event.event_name, event.description, event.long_description, event.start_date, event.end_date, " +
                "event.user_activity_goal, event.total_activity_goal, event.image_name " +
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

    @Override
    public Event addNewEvent(Event event) {
        Event newEvent = new Event();

        String sql = "INSERT INTO event (event_id, event_name, description, long_description, " +
                    "start_date, end_date, user_activity_goal, total_activity_goal, image_name) " +
                    "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING event_id";

        Date adjustedStartDate = event.getStartDate();
        Calendar c = Calendar.getInstance();
        c.setTime(adjustedStartDate);
        c.add(Calendar.DATE, 1);
        adjustedStartDate = (c.getTime());
        event.setStartDate(adjustedStartDate);

        Date adjustedEndDate = event.getEndDate();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(adjustedEndDate);
        c2.add(Calendar.DATE, 1);
        adjustedEndDate = (c2.getTime());
        event.setEndDate(adjustedEndDate);

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, event.getEventName(), event.getDescription(),
        event.getLongDescription(), event.getStartDate(), event.getEndDate(), event.getUserActivityGoal(),
        event.getTotalActivityGoal(), "CoachSteve.jpg");

       int newEventId = 0;
       if (results.next()) {
           newEventId = results.getInt("event_id");
       }
       newEvent.setEventId(newEventId);

       List<String>  activityList = new ArrayList<>();
       activityList = event.getActivityType();
       for (String activity : activityList) {

           String sql2 = "SELECT activity_type_id FROM activity_type " +
                     "WHERE activity_type = ?";

           SqlRowSet activityResult = jdbcTemplate.queryForRowSet(sql2, activity);
           int newActivityId = 0;
           if (activityResult.next()) {
               newActivityId = activityResult.getInt("activity_type_id");
           }

           String sql3 = "INSERT INTO event_activity_type (event_id, activity_type_id) " +
                        "VALUES (?, ?)";

           jdbcTemplate.update(sql3, newEventId, newActivityId);
       }

        return newEvent;
    }

    @Override
    public List<UserProfile> retrieveUsersByEventId(int eventId) {
        List<UserProfile> userList = new ArrayList<>();

        String sqlUsers = "SELECT user_profile_id, user_profile.user_id, first_name, last_name, " +
                "email_address, handle FROM user_profile " +
                "JOIN event_user on user_profile.user_id = event_user.user_id " +
                "WHERE event_id = ?";

        SqlRowSet userResults = jdbcTemplate.queryForRowSet(sqlUsers, eventId);

        while(userResults.next()) {
            UserProfile userProfile = mapRowToUserProfile(userResults);
            userList.add(userProfile);
        }
        return userList;
    }


    private Event mapRowToEvent(SqlRowSet results) {
        Event event = new Event();
        event.setEventId(results.getInt("event_id"));
        event.setEventName(results.getString("event_name"));
        event.setDescription(results.getString("description"));
        event.setLongDescription(results.getString("long_description"));
        event.setStartDate(results.getDate("start_date"));
        event.setEndDate(results.getDate("end_date"));
        event.setUserActivityGoal(results.getDouble("user_activity_goal"));
        event.setTotalActivityGoal(results.getDouble("total_activity_goal"));
        event.setImageName(results.getString("image_name"));

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

    private UserProfile mapRowToUserProfile(SqlRowSet results) {
        UserProfile userProfile = new UserProfile();

        userProfile.setUserId(results.getInt("user_id"));
        userProfile.setFirstName(results.getString("first_name"));
        userProfile.setLastName(results.getString("last_name"));
        userProfile.setEmailAddress(results.getString("email_address"));
        userProfile.setHandle(results.getString("handle"));

        return userProfile;
    }
}
