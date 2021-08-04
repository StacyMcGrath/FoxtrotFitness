package com.techelevator.controller;
import com.techelevator.dao.ActivityDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Activity;
import com.techelevator.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ActivityController {

    private ActivityDAO activityDAO;
    private UserDAO userDAO;

    public ActivityController(ActivityDAO activityDAO, UserDAO userDAO) {
        this.activityDAO = activityDAO;
        this.userDAO = userDAO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/dashboard", method = RequestMethod.POST)
    public void logActivity(@RequestBody Activity activity, Principal principal) {
        activity.setUserID(userDAO.findIdByUsername(principal.getName()));
        activityDAO.logActivity(activity);
        //userDAO.findIdByUsername(principal.getName())
    }

    @RequestMapping(path = "/dashboard/activities", method = RequestMethod.GET)
    public List<Activity> getActivities(Principal principal) {
        return activityDAO.retrieveActivitiesByUser(userDAO.findIdByUsername(principal.getName()));
    }
}
