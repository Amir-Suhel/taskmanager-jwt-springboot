package com.mycompany.taskmanager.repository;

import com.mycompany.taskmanager.model.ERole;
import com.mycompany.taskmanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
