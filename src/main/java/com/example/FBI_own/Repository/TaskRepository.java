package com.example.FBI_own.Repository;

import com.example.FBI_own.Entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskItem, Long> {
}
