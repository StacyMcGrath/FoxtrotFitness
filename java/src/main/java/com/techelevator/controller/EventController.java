package com.techelevator.controller;


import com.techelevator.dao.EventDAO;
import com.techelevator.model.Event;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    private EventDAO eventDAO;

    public EventController(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventDAO.retrieveEvents();
    }
}
