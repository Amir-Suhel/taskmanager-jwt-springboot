package com.mycompany.taskmanager.repository;

import com.mycompany.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTitleContains(String title);
}
