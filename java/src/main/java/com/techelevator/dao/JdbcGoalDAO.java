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
            Goal goal = mapRowToGoal(results);
            premadeGoalList.add(goal);
        }
        return premadeGoalList;
    }




    @Override
    public Goal retrieveGoalById(int goalId) {
        return null;
    }

    @Override
    public List<Goal> retrieveGoalsByUser(int userId) {
        return null;
    }

    @Override
    public Goal addNewGoal(Goal goal) {
        return null;
    }

    private Goal mapRowToGoal(SqlRowSet results){
        Goal goal = new Goal();
        return goal;
    }
}
