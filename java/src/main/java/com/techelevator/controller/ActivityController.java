package com.techelevator.controller;
import com.techelevator.dao.ActivityDAO;
import com.techelevator.model.Activity;
import org.springframework.http.HttpStatus;
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


@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    private ActivityDAO activityDAO;

    public ActivityController(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/dashboard", method = RequestMethod.POST)
    public void logActivity(@RequestBody Activity activity) {
        activity.setUserID(5);
        activityDAO.logActivity(activity);
        //userDAO.findIdByUsername(principal.getName())
    }
}
