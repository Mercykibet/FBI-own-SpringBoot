package com.example.FBI_own.Service;

import com.example.FBI_own.Entity.TaskItem;
import com.example.FBI_own.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskItem> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskItem> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskItem createTask(TaskItem task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
