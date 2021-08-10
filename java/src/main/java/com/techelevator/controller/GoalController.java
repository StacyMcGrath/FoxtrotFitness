package com.techelevator.controller;

import com.techelevator.dao.EventDAO;
import com.techelevator.dao.GoalDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Event;
import com.techelevator.model.Goal;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin

public class GoalController {

    private UserDAO userDAO;

    private GoalDAO goalDAO;

    public GoalController(GoalDAO goalDAO, UserDAO userDAO) {
        this.goalDAO = goalDAO;
        this.userDAO = userDAO;
    }

    @RequestMapping(path = "/goals/premade", method = RequestMethod.GET)
    public List<Goal> getPremadeGoals() {
        return goalDAO.retrievePremadeGoals();
    }

    @RequestMapping(path = "/goals/{goalId}", method = RequestMethod.GET)
    public Goal getGoalByGoalId(@PathVariable int goalId) {
        return goalDAO.retrieveGoalById(goalId);
    }

    @RequestMapping(path = "/dashboard/goals", method = RequestMethod.GET)
    public List<Goal> getGoalsByUserId(Principal principal) {
        return goalDAO.retrieveGoalsByUser(userDAO.findIdByUsername(principal.getName()));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/createGoal", method = RequestMethod.POST)
    public void createNewGoal(@RequestBody Goal goal, Principal principal) {
        goalDAO.addNewGoal(goal, userDAO.findIdByUsername((principal.getName())));
    }
}
