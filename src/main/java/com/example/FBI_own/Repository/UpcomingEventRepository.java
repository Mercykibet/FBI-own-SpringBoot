package com.example.FBI_own.Repository;

import com.example.FBI_own.Entity.UpcomingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UpcomingEventRepository extends JpaRepository<UpcomingEvent, Long> {

    // Custom Query to Fetch Future Events
    @Query("SELECT e FROM UpcomingEvent e WHERE e.date >= :currentDate ORDER BY e.date ASC")
    List<UpcomingEvent> findUpcomingEvents(LocalDate currentDate);
}
