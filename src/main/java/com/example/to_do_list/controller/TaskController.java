package com.example.to_do_list.controller;

import com.example.to_do_list.model.Task;
import com.example.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(name = "/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllcompletedTasks(){
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }
    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> getAllIncompletedTasks(){
        return ResponseEntity.ok(taskService.findAllInCompletedTask());
    }
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }
    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
}
