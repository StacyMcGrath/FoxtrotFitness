package com.techelevator.controller;

import com.techelevator.dao.EventDAO;
import com.techelevator.dao.GoalDAO;
import com.techelevator.dao.UserDAO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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
}
