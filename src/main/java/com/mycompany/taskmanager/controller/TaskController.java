package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dto.TaskDTO;
import com.mycompany.taskmanager.service.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO){
       Long taskId = taskService.createTask(taskDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully with Id "+taskId);
    }
}
