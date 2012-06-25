package com.github.checketts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.checketts.model.Event;

@Service
public class EventServiceImpl implements EventService {

    private List<Event> allEvents;
    
    public EventServiceImpl() {
        allEvents = new ArrayList<Event>();
        allEvents.add(new Event(1,"50 Meter Dash"));
        allEvents.add(new Event(2,"100 Meter Dash"));

    }
    
    public List<Event> getAllEvents() {
        return allEvents;
    }

}
