package com.example.FBI_own.Service;


import com.example.FBI_own.Entity.Tasks;
import com.example.FBI_own.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();

    }

    public Optional<Tasks> getTaskById(Long id) {

        return taskRepository.findById(id);
    }

    public Tasks createTask(Tasks task) {


        return taskRepository.save(task);
    }


    public void deleteTask(Long id) {

        taskRepository.deleteById(id);
    }
}
