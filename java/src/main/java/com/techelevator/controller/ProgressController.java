package com.techelevator.controller;

import com.techelevator.dao.ProgressDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Event;
import com.techelevator.model.Progress;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ProgressController {

    private ProgressDAO progressDAO;
    private UserDAO userDAO;

    public ProgressController(ProgressDAO progressDAO, UserDAO userDAO) {
        this.progressDAO = progressDAO;
        this.userDAO = userDAO;
    }

    @RequestMapping(path = "/progress/{eventId}", method = RequestMethod.GET)
    public List<Progress> getProgressByEventForAllUsers(@PathVariable int eventId) {
        return progressDAO.retrieveProgressByEventForAllUsers(eventId);
    }

    @RequestMapping(path = "/progress/individual/{eventId}", method = RequestMethod.GET)
    public List<Progress> getProgressByEventForIndividualUser(@PathVariable int eventId, Principal principal) {
        return progressDAO.retrieveProgressByEventForUser(eventId, userDAO.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/progress/goal/{goalId}", method = RequestMethod.GET)
    public List<Progress> getProgressByGoalForIndividualUser(@PathVariable int goalId, Principal principal) {
        return progressDAO.retrieveProgressByGoalForUser(goalId, userDAO.findIdByUsername(principal.getName()));
    }

}
