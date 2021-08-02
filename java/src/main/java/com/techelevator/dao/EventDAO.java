package com.techelevator.dao;

import com.techelevator.model.Event;
import java.util.List;

public interface EventDAO {

    List<Event> retrieveEvents();
    Event retrieveEventById(int eventId);

}
