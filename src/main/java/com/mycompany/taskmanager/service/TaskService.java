package com.mycompany.taskmanager.service;

import com.mycompany.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    Long createTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTasks();
    TaskDTO getTask(Long taskId);
    Void deleteTask(Long taskId);
    TaskDTO updateTask(TaskDTO taskDTO);
    List<TaskDTO> searchTaskByTitle(String title);

}
