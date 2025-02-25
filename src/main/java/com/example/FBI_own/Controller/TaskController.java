package com.example.FBI_own.Controller;

import com.example.FBI_own.Entity.TaskItem;
import com.example.FBI_own.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    /*private final List<TaskItem> tasks = new ArrayList<>(List.of(
            new TaskItem(1L, "Task 1", "Description for Task 1"),
            new TaskItem(2L, "Task 2", "Description for Task 2"),
            new TaskItem(3L, "Task 3", "Description for Task 3")
    ));*/

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getTasks")
    public List<TaskItem> getAllTasks() {
        return taskService.getAllTasks();
       //return tasks;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskItem> getTaskById(@PathVariable Long id) {
        Optional<TaskItem> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createTask")
    public TaskItem createTask(@RequestBody TaskItem task) {
        return taskService.createTask(task);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully.");
    }
}
