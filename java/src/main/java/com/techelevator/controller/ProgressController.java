package com.techelevator.controller;

import com.techelevator.dao.GoalDAO;
import com.techelevator.dao.ProgressDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Event;
import com.techelevator.model.Goal;
import com.techelevator.model.Progress;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ProgressController {

    private ProgressDAO progressDAO;
    private UserDAO userDAO;
    private GoalDAO goalDAO;

    public ProgressController(ProgressDAO progressDAO, UserDAO userDAO, GoalDAO goalDAO) {
        this.progressDAO = progressDAO;
        this.userDAO = userDAO;
        this.goalDAO = goalDAO;
    }

    @RequestMapping(path = "/progress/{eventId}", method = RequestMethod.GET)
    public List<Progress> getProgressByEventForAllUsers(@PathVariable int eventId) {
        return progressDAO.retrieveProgressByEventForAllUsers(eventId);
    }

    @RequestMapping(path = "/progress/individual/{eventId}", method = RequestMethod.GET)
    public List<Progress> getProgressByEventForIndividualUser(@PathVariable int eventId, Principal principal) {
        return progressDAO.retrieveProgressByEventForUser(eventId, userDAO.findIdByUsername(principal.getName()));
    }

//    @RequestMapping(path = "/progress/goal", method = RequestMethod.GET)
//    public List<Progress> getProgressByGoalForIndividualUser(Principal principal) {
//        List<Goal> goals = goalDAO.retrieveGoalsByUser(userDAO.findIdByUsername(principal.getName()));
//        List<Progress> goalsProgress = new ArrayList<>();
//        for(Goal goal: goals) {
//            List <Progress> individualProgressList = progressDAO.retrieveProgressByGoalForUser(goal.getGoalId(), goal.getUserId());
//
//        }
//        return ;
//    }

}
