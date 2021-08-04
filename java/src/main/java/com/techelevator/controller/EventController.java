package com.techelevator.controller;


import com.techelevator.dao.EventDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Event;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    private UserDAO userDAO;

    private EventDAO eventDAO;

    public EventController(EventDAO eventDAO, UserDAO userDAO) {
        this.eventDAO = eventDAO;
        this.userDAO = userDAO;
    }

    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventDAO.retrieveEvents();
    }

    @RequestMapping(path = "/events/{eventId}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int eventId) {
        return eventDAO.retrieveEventById(eventId);
    }

    @RequestMapping(path = "/dashboard/events", method = RequestMethod.GET)
    public List<Event> getEventsByUser(Principal principal) {
        return eventDAO.retrieveEventsByUser(userDAO.findIdByUsername(principal.getName()));
        //userDAO.findIdByUsername(principal.getName())
    }
}
