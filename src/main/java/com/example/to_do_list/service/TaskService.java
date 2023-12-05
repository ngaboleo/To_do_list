package com.example.to_do_list.service;

import com.example.to_do_list.model.Task;
import com.example.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task findTaskById(UUID id){
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompletedTask(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllInCompletedTask(){
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(UUID id){
         taskRepository.deleteById(id);
    }

    public Task updateTask (Task task){
        return taskRepository.save(task);
    }
}
