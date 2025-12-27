package com.example.FBI_own.Service;

import com.example.FBI_own.Dto.UpcomingEventDto;
import com.example.FBI_own.Entity.UpcomingEvent;
import com.example.FBI_own.Repository.UpcomingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpcomingEventService {

    @Autowired
    private UpcomingEventRepository eventRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Fetch all upcoming events and return as DTOs
    public List<UpcomingEventDto> getUpcomingEvents() {
        return eventRepository.findUpcomingEvents(LocalDate.now()).stream()
                .map(event -> new UpcomingEventDto(
                        event.getTitle(),
                        event.getPlace(),
                        event.getDate().toString())) // Convert LocalDate to String
                .collect(Collectors.toList());
    }

    // Convert DTO to Entity and save it
    public void createEvent(UpcomingEventDto eventDTO) {
        UpcomingEvent event = new UpcomingEvent(
                eventDTO.getTitle(),
                eventDTO.getPlace(),
                LocalDate.parse(eventDTO.getDate(), formatter)
        );

        // Save to database
         eventRepository.save(event);

    }
}
