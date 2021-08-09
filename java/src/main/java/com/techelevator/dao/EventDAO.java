package com.techelevator.dao;

import com.techelevator.model.Activity;
import com.techelevator.model.Event;
import com.techelevator.model.UserEvent;

import java.util.List;

public interface EventDAO {

    List<Event> retrieveEvents();
    Event retrieveEventById(int eventId);
    List<Event> retrieveEventsByUser(int userId);
    void addEventToUser(UserEvent userEvent);
    Event addNewEvent(Event event);

}
