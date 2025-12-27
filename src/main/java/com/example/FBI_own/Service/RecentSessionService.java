package com.example.FBI_own.Service;

import com.example.FBI_own.Dto.RecentSessionDto;
import com.example.FBI_own.Entity.RecentSession;
import com.example.FBI_own.Repository.RecentSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecentSessionService {

    @Autowired
    private RecentSessionRepository eventRepository;

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public RecentSessionService(RecentSessionRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Fetch all recent sessions and return as DTOs
    public List<RecentSessionDto> getRecentSessions() {
        return eventRepository.findAll().stream()
                .map(session -> new RecentSessionDto(
                        session.getTitle(),
                        session.getDate().format(dateFormatter),
                        session.getTime().format(timeFormatter)
                ))
                .collect(Collectors.toList());
    }

    // Convert DTO to Entity and save it
    public RecentSessionDto createSession(RecentSessionDto sessionDTO) {
        RecentSession event = new RecentSession(
                sessionDTO.getTitle(),
                LocalDate.parse(sessionDTO.getDate(), dateFormatter),
                LocalTime.parse(sessionDTO.getTime(), timeFormatter)
        );
        RecentSession savedEvent = eventRepository.save(event);
        return new RecentSessionDto(
                savedEvent.getTitle(),
                savedEvent.getDate().format(dateFormatter),
                savedEvent.getTime().format(timeFormatter)
        );
    }
}
