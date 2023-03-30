package com.mycompany.taskmanager.service;

import com.mycompany.taskmanager.dto.ErrorDTO;
import com.mycompany.taskmanager.dto.TaskDTO;
import com.mycompany.taskmanager.exception.BusinessException;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.model.User;
import com.mycompany.taskmanager.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Long createTask(TaskDTO taskDTO) {

        Optional<Task> optTask = taskRepository.findByTitleContains(taskDTO.getTitle());
        if(optTask.isPresent()){
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode("DUP_001");
            errorDTO.setMessage(String.format("Task with title %s already exist", taskDTO.getTitle()));
            List<ErrorDTO> errorDTOS = Arrays.asList(errorDTO);
            throw new BusinessException(errorDTOS);
        }

        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        task = taskRepository.save(task);
        return task.getId();
    }

    @Override
    public List<TaskDTO> getAllTasks() {

        return null;
    }

    @Override
    public TaskDTO getTask(Long taskId) {
        return null;
    }

    @Override
    public Void deleteTask(Long taskId) {
        return null;
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public List<TaskDTO> searchTaskByTitle(String title) {
        return null;
    }
}
