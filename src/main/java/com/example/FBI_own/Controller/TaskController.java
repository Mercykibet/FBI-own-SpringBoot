package com.example.FBI_own.Controller;

import com.example.FBI_own.Entity.TaskItem;
import com.example.FBI_own.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //add task
    @PostMapping("/createTask")
    public ResponseEntity<TaskItem> createdTask(@RequestBody TaskItem task){
        try {
            TaskItem createdTask=taskService.createTask(task);
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
            //return ResponseEntity.ok(createdTask);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }



    }

    //fetch all task
    @GetMapping("/getTasks")
    public ResponseEntity<List<TaskItem>> getAllTasks() {
        List<TaskItem> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Fetch a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskItem> getTaskById(@PathVariable Long id) {
        Optional<TaskItem> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully.");
    }
}
