package com.example.FBI_own.Controller;

import com.example.FBI_own.Dto.RecentSessionDto;
import com.example.FBI_own.Dto.UpcomingEventDto;
import com.example.FBI_own.Service.RecentSessionService;
import com.example.FBI_own.Service.UpcomingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private UpcomingEventService eventService;
    @Autowired
    private RecentSessionService recentSessionService;

    // Fetch upcoming events
    @GetMapping("/upcoming")
    public List<UpcomingEventDto> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }

    // Add a new event
    @PostMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody UpcomingEventDto eventDTO) {
        eventService.createEvent(eventDTO);
        return ResponseEntity.ok("Added");
    }


    // Endpoint to fetch all recent sessions
    @GetMapping("/recentSession")
    public List<RecentSessionDto> getRecentSessions() {
        return recentSessionService.getRecentSessions();
    }

    // Endpoint to create a new recent session
    @PostMapping("/addSession")
    public RecentSessionDto createRecentSession(@RequestBody RecentSessionDto sessionDto) {
        return recentSessionService.createSession(sessionDto);
    }

}
