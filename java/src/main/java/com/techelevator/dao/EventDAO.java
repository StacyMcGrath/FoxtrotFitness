package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface EventDAO {

    List<Event> retrieveEvents();
    Event retrieveEventById(int eventId);
    List<Event> retrieveEventsByUser(int userId);
    void addEventToUser(UserEvent userEvent);
    Event addNewEvent(Event event);
    List<UserProfile> retrieveUsersByEventId(int eventId);



}
