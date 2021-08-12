package com.techelevator.controller;


import com.techelevator.dao.EventDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class EventController {

    private UserDAO userDAO;

    private EventDAO eventDAO;

    public EventController(EventDAO eventDAO, UserDAO userDAO) {
        this.eventDAO = eventDAO;
        this.userDAO = userDAO;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventDAO.retrieveEvents();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/events/{eventId}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int eventId) {
        return eventDAO.retrieveEventById(eventId);
    }

    @RequestMapping(path = "/dashboard/events", method = RequestMethod.GET)
    public List<Event> getEventsByUser(Principal principal) {
        return eventDAO.retrieveEventsByUser(userDAO.findIdByUsername(principal.getName()));
        //userDAO.findIdByUsername(principal.getName())
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/myEvents", method = RequestMethod.POST)
    public void addUserToEvent(@RequestBody Event event, Principal principal) {
        UserEvent userEvent = new UserEvent();
        userEvent.setEventId(event.getEventId());
        userEvent.setUserID(userDAO.findIdByUsername(principal.getName()));
        eventDAO.addEventToUser(userEvent);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/createEvent", method = RequestMethod.POST)
    public void createNewEvent(@RequestBody Event event) {
        eventDAO.addNewEvent(event);
    }

    @RequestMapping(path = "/events/{eventId}/users", method = RequestMethod.GET)
    public List<UserProfile> getUsersByEvent(@PathVariable int eventId) {
        return eventDAO.retrieveUsersByEventId(eventId);
    }

    @RequestMapping(path = "/header", method = RequestMethod.GET)
    public UserProfile getUserProfile(Principal principal) {
        return eventDAO.getUserProfileForLoggedInUser(userDAO.findIdByUsername(principal.getName()));
    }
}
