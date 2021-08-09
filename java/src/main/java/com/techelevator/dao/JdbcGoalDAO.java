package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Goal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGoalDAO implements GoalDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcGoalDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Goal> retrievePremadeGoals() {
        List<Goal> premadeGoalList = new ArrayList<Goal>();

        String sql = "SELECT premade_goal_id, premade_goal_name, premade_goal_description, premade_user_activity_goal, " +
                "premade_goal_units FROM premade_goals";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while (results.next()) {
            Goal goal = mapRowToPremadeGoal(results);
            premadeGoalList.add(goal);
        }
        return premadeGoalList;
    }

    @Override
    public Goal retrieveGoalById(int goalId) {
        Goal goal = null;

        String sql = "SELECT goal_id, goal_name, start_date, end_date, user_activity_goal, " +
                "goal_units, user_id FROM goals WHERE goal_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, goalId);

        if (result.next()) {
            goal = mapRowToGoal(result);
        }
        return goal;
    }

    @Override
    public List<Goal> retrieveGoalsByUser(int userId) {
        List<Goal> goalList = new ArrayList<Goal>();

        String sql = "SELECT goal_id, goal_name, start_date, end_date, user_activity_goal, " +
                "goal_units, user_id FROM goals WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Goal goal = mapRowToGoal(results);
            goalList.add(goal);
        }

        return goalList;
    }

    @Override
    public Goal addNewGoal(Goal goal) {
        String sql = "INSERT INTO goals (goal_id, goal_name, start_date, end_date, user_activity_goal, goal_units, " +
        "user_id) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING goal_id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, goal.getGoalName(), goal.getStartDate(), goal.getEndDate(),
                goal.getActivityGoal(), goal.getActivityUnits(), goal.getUserId());

        int newGoalId = 0;
        if (results.next()) {
            newGoalId = results.getInt("goal_id");
        }
        goal.setGoalId(newGoalId);
        return goal;
    }

    private Goal mapRowToPremadeGoal(SqlRowSet results){
        Goal goal = new Goal();

        goal.setGoalId(results.getInt("premade_goal_id"));
        goal.setGoalName(results.getString("premade_goal_name"));
        goal.setDescription(results.getString("premade_goal_description"));
        goal.setActivityGoal(results.getDouble("premade_user_activity_goal"));
        goal.setActivityUnits(results.getString("premade_goal_units"));

        List <String> activityListForGoal = getActivityListForPremadeGoal(results.getInt("premade_goal_id"));
        if(activityListForGoal != null) {
            goal.setActivityType(activityListForGoal);
        }

        return goal;
    }

    private List<String> getActivityListForPremadeGoal(int premadeGoalId) {

        String sql = "SELECT activity_type.activity_type FROM activity_type " +
                "JOIN premade_goal_activity_type ON premade_goal_activity_type.activity_type_id = activity_type.activity_type_id " +
                "JOIN premade_goals ON premade_goals.premade_goal_id = premade_goal_activity_type.premade_goal_id " +
                "WHERE premade_goals.premade_goal_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, premadeGoalId);

        List<String> activityListForGoal = new ArrayList<>();

        while (results.next()) {

            String activity_type = results.getString("activity_type");
            activityListForGoal.add(activity_type);
        }

        return activityListForGoal;

    }
    private Goal mapRowToGoal(SqlRowSet result){
        Goal goal = new Goal();

        goal.setGoalId(result.getInt("goal_id"));
        goal.setGoalName(result.getString("goal_name"));
        goal.setStartDate(result.getDate("start_date"));
        goal.setEndDate(result.getDate("end_date"));
        goal.setActivityGoal(result.getDouble("user_activity_goal"));
        goal.setActivityUnits(result.getString("goal_units"));
        goal.setUserId(result.getInt("user_id"));

        List <String> activityListForGoal = getActivityListForGoal(result.getInt("goal_id"));
        if(activityListForGoal != null) {
            goal.setActivityType(activityListForGoal);
        }

        return goal;
    }

    private List<String> getActivityListForGoal(int goalId) {

        String sql = "SELECT activity_type.activity_type FROM activity_type " +
                "JOIN goal_activity_type ON goal_activity_type.activity_type_id = activity_type.activity_type_id " +
                "JOIN goals ON goals.goal_id = goal_activity_type.goal_id " +
                "WHERE goals.goal_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, goalId);

        List<String> activityListForGoal = new ArrayList<>();

        while (results.next()) {

            String activity_type = results.getString("activity_type");
            activityListForGoal.add(activity_type);
        }

        return activityListForGoal;

    }
}
