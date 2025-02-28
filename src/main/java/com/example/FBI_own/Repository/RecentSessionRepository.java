package com.example.FBI_own.Repository;

import com.example.FBI_own.Entity.RecentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentSessionRepository extends JpaRepository<RecentSession,Long> {
}
