package com.techelevator.controller;

import com.techelevator.dao.ProgressDAO;
import com.techelevator.model.Event;
import com.techelevator.model.Progress;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ProgressController {

    private ProgressDAO progressDAO;

    public ProgressController(ProgressDAO progressDAO) {
        this.progressDAO = progressDAO;
    }

    @RequestMapping(path = "/progress/{eventId}", method = RequestMethod.GET)
    public List<Progress> getProgressByEventForAllUsers(@PathVariable int eventId) {
        return progressDAO.retrieveProgressByEventForAllUsers(eventId);
    }

    
}
